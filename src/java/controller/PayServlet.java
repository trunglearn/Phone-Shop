package controller;

import com.google.gson.Gson;
import dao.DetailsOfInvoiceItemsDAOImpl;
import dao.InvoiceDAOImpl;
import dao.ProductDAOImpl;
import dao.AccountDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DetailsOfInvoiceItems;
import model.Cart;
import model.CartItem;
import model.Invoice;
import model.Product;
import model.Account;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayServlet extends HttpServlet {

    private final InvoiceDAOImpl InvoiceDAO = new InvoiceDAOImpl();
    private final DetailsOfInvoiceItemsDAOImpl DetailsOfInvoiceItemsDAO = new DetailsOfInvoiceItemsDAOImpl();
    private final AccountDAOImpl AccountDAOI = new AccountDAOImpl();
    private final ProductDAOImpl ProductDAO = new ProductDAOImpl();
    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String checkoutAction = request.getParameter("checkoutAction");

        System.out.println("check request to doGet() of PayServlet");

        if ("fetchCart".equals(checkoutAction)) {
            // Get cart from cookies
            Cart cart = getCartFromCookie(request);
            System.out.println("check request to if of doGet");
            // Set the cart as a request attribute
            request.setAttribute("cart", cart);

            // Forward the request to the checkout.jsp page
            RequestDispatcher dispatcher = request.getRequestDispatcher("/checkout.jsp");
            dispatcher.forward(request, response);
        } else {
            // Handle other actions or perform the payment logic
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String deliveryAddress = request.getParameter("Delivery_address");
        String phone = request.getParameter("Phone");
        String paymentMethod = request.getParameter("Payment_method");

        String diaChiError = "";
        String phoneError = "";
        String phuongThucError = "";

        if (deliveryAddress.equals("")) {
            diaChiError = "Vui lòng nhập địa chỉ giao hàng";
        }
        if (phone.equals("")) {
            phoneError = "Vui lòng nhập số điện thoại";
        }
        if (paymentMethod.equals("")) {
            phuongThucError = "Vui lòng nhập phương thức thanh toán";
        }

        if (diaChiError.length() > 0 || phoneError.length() > 0 || phuongThucError.length() > 0) {
            request.setAttribute("dia_chi_erro", diaChiError);
            request.setAttribute("Phone_err", phoneError);
            request.setAttribute("phuong_thuc_erro", phuongThucError);
            request.setAttribute("Delivery_address", deliveryAddress);
            request.setAttribute("Phone", phone);
            request.setAttribute("Payment_method", paymentMethod);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/checkout.jsp");
            rd.forward(request, response);
        } else {
            HttpSession session = request.getSession();

            // Get cart from cookies
            Cart cart = getCartFromCookie(request);

            String accountUsername = (String) session.getAttribute("username");

            try {
                Account account = AccountDAOI.getAccount(accountUsername);
                if (account != null) {
                    // Account found, proceed with creating invoice
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String date = dateFormat.format(new Date());
                    int s = (int) new Date().getTime();
                    int invoiceID = Math.abs(s);

                    Invoice invoice = new Invoice();
                    invoice.setID_Invoice(invoiceID);
                    invoice.setID_Account(account.getID_Account());
                    invoice.setTotal_amount(cart.total());
                    invoice.setDelivery_address(deliveryAddress);
                    invoice.setPayment_method(paymentMethod);
                    invoice.setPurchase_date(date);
                    invoice.setOrder_status(0);

                    InvoiceDAO.themInvoice(invoice);

                    for (CartItem cartItem : cart.getItems()) {
                        Product product = cartItem.getProduct();
                        DetailsOfInvoiceItemsDAO.insertDetailsOfInvoiceItems(new DetailsOfInvoiceItems(
                                invoiceID, product.getID_Product(), cartItem.getQuantity(),
                                product.getUnit_price(), product.getDiscount(),
                                cartItem.getQuantity() * product.getUnit_price() - (cartItem.getQuantity() * product.getUnit_price() * product.getDiscount()) / 100));

                        ProductDAO.updateProduct(new Product(
                                product.getID_Product(), product.getName_Product(), product.getID_Category(),
                                product.getImage(), product.getQuantity() - cartItem.getQuantity(),
                                product.getUnit_price(), product.getDiscount(), product.getDisplay(),
                                product.getRear_camera(), product.getFront_camera(), product.getOperating_system(),
                                product.getCpu(), product.getMemory(), product.getRam(), product.getConnectivity(),
                                product.getBattery(), product.getDescription()));
                    }

                    // Clear the cart after successful payment
                    cart.getItems().clear();
                    updateCartCookie(response, cart);

                    response.sendRedirect("/PRJ301/default.jsp");
                } else {
                    // Handle case where account is not found
                    // This could be due to session timeout or invalid session
                    // Redirect to login or display an error message
                    // For example:
                    response.sendRedirect("/PRJ301/account.jsp");
                }
            } catch (Exception e) {
                e.printStackTrace();
                // Handle failure, redirect to an error page or display an error message
                response.sendRedirect("/PRJ301/error.jsp");
            }
        }
    }

    private Cart getCartFromCookie(HttpServletRequest request) {
        Cart cart = null;
        Cookie[] cookies = request.getCookies();

        System.out.println("check enter getCartFromCookie when access checkout page: true");

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    try {
                        String decodedValue = java.net.URLDecoder.decode(cookie.getValue(), java.nio.charset.StandardCharsets.UTF_8.toString());
                        System.out.println("Decoded Cart Value: " + decodedValue);
                        cart = gson.fromJson(decodedValue, Cart.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (cart == null) {
            System.out.println("Cart is null");
            cart = new Cart();
        }

        return cart;
    }

    private void updateCartCookie(HttpServletResponse response, Cart cart) {
        try {
            String cartJson = gson.toJson(cart);
            String encodedCartJson = java.net.URLEncoder.encode(cartJson, java.nio.charset.StandardCharsets.UTF_8.toString());
            Cookie cookie = new Cookie("cart", encodedCartJson);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
