package controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import dao.ProductDAOImpl;
import jakarta.servlet.RequestDispatcher;
import model.Cart;
import model.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CartServlet extends HttpServlet {

    private final Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("ID_Product"));
            Cart cart = getCartFromCookie(request);

            String command = request.getParameter("command");
            String url = "/cart.jsp";

            Product product = getProductById(productId);

            System.out.println("Product ID: " + productId);
            System.out.println("Command: " + command);
            System.out.println("Cart before: " + gson.toJson(cart));

            switch (command) {
                case "insert":
                    addToCart(cart, product, 1);
                    break;
                case "plus":
                    addToCart(cart, product, 1);
                    break;
                case "sub":
                    subToCart(cart, product, 1);
                    break;
                case "remove":
                    removeFromCart(cart, product);
                    break;
                default:
                    break;
            }

            System.out.println("Cart after: " + gson.toJson(cart));

            // Cập nhật cookie
            updateCartCookie(response, cart);

            // Chuyển hướng đến trang cart.jsp
            response.sendRedirect(request.getContextPath() + "/cart.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Cart getCartFromCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        Cart cart = null;
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    try {
                        // Giải mã giá trị của cookie trước khi chuyển đổi thành đối tượng Cart
                        String decodedValue = java.net.URLDecoder.decode(cookie.getValue(), java.nio.charset.StandardCharsets.UTF_8.toString());
                        cart = gson.fromJson(decodedValue, Cart.class);
                    } catch (JsonSyntaxException | UnsupportedEncodingException e) {
                        e.printStackTrace();
                        // Xử lý nếu giá trị không phải là chuỗi JSON hợp lệ
                    }
                }
            }
        }

        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    private void updateCartCookie(HttpServletResponse response, Cart cart) {
        try {
            // Convert Cart object to JSON
            String cartJson = gson.toJson(cart);

            // URL encode the JSON string before setting it as the cookie value
            String encodedCartJson = java.net.URLEncoder.encode(cartJson, java.nio.charset.StandardCharsets.UTF_8.toString());

            // Create and add the cookie
            Cookie cookie = new Cookie("cart", encodedCartJson);

            // Set the cookie path to make it accessible across all pages
            cookie.setPath("/");
            
            System.out.println("Received JSON String from CartServlet: " + cartJson);

            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private Product getProductById(int productId) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        // Gọi phương thức để lấy thông tin sản phẩm từ cơ sở dữ liệu
        Product product = productDAO.getProductById(productId);

        return product;
    }

    private void addToCart(Cart cart, Product product, int quantity) {
        cart.addToCart(product, quantity);
    }

    private void subToCart(Cart cart, Product product, int quantity) {
        cart.subToCart(product, quantity);
    }

    private void removeFromCart(Cart cart, Product product) {
        cart.removeToCart(product);
    }
}
