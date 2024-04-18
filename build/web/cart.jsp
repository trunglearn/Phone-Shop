<%@page import="java.text.NumberFormat"%>
<%@page import="model.Cart"%>
<%@page import="model.CartItem"%>
<%@page import="model.Product"%>
<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page import="com.google.gson.JsonSyntaxException" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Locale" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
                <link rel="icon" type="image/x-icon" href="https://th.bing.com/th/id/R.e15d750fe41eb99350f0c56e6b66b653?rik=QJI66s2o67Q7jw&pid=ImgRaw&r=0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>

        <!-- Bao gồm jQuery -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    </head>
    <body>

        <%-- Initialize NumberFormat --%>
        <%@ page import="java.text.NumberFormat" %>
        <% NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
           nf.setMaximumFractionDigits(2);
        %>

        <%!
            // Function to check if a JSON string is valid
            private boolean isJSONValid(String jsonInString) {
                try {
                    new Gson().fromJson(jsonInString, Object.class);
                    return true;
                } catch (JsonSyntaxException ex) {
                    return false;
                }
            }
        %>

        <%
             Cart cart = null;
            String cartJson = "";

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cart")) {
                        cartJson = URLDecoder.decode(cookie.getValue(), "UTF-8");
                        break;
                    }
                }
            }

            // Debugging cartJson
    //        out.println("Cart JSON from Cookie: " + cartJson);

            if (cartJson != null && !cartJson.isEmpty()) {
                try {
                    // Check if the JSON string is valid before converting
                    if (isJSONValid(cartJson) && cartJson.contains("\"items\":")) {
                        // If it contains "items" field, assume it's a valid cart JSON
                        cart = new Gson().fromJson(cartJson, Cart.class);
    //                    out.println("Parsed Cart: " + new Gson().toJson(cart));
                    } else {
                        // Handle the case where JSON is not valid
                        out.println("Invalid Cart JSON. Creating a new Cart.");
                        cart = new Cart();
                    }
                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    // Handle the exception if JSON conversion fails
                    out.println("Error parsing Cart JSON. Creating a new Cart.");
                    cart = new Cart();
                }
            } else {
                // Handle the case where cartJson is null or empty
                //out.println("No Cart JSON found. Creating a new Cart.");
                cart = new Cart();
            }

            if (cart == null) {
                cart = new Cart();
            }
        %>

        <!-- Header includes the necessary CSS and JS files -->
        <jsp:include page="header1.jsp"></jsp:include>

            <!-- Cart items section -->
            <section id="cart_items">
                <div class="container">
                    <div class="breadcrumbs">
                        <ol class="breadcrumb">
                            <li><a href="#">Home</a></li>
                            <li class="active">PhoneShop Cart</li>
                        </ol>
                    </div>
                    <div class="table-responsive cart_info">
                        <table class="table table-condensed">
                            <thead>
                                <tr class="cart_menu">
                                    <td class="image">Sản phẩm</td>
                                    <td class="description"></td>
                                    <td class="price">Giá</td>
                                    <td class="price">Giảm giá</td>
                                    <td class="quantity">Số lượng</td>
                                    <td class="total">Thành tiền</td>
                                    <td></td>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                                if (cart.getItems() == null || cart.getItems().isEmpty()) {
                                    out.println("<tr><td colspan=\"7\">Giỏ hàng trống</td></tr>");
                                } else {
                                    for (CartItem cartItem : cart.getItems()) {
                                        Product product = cartItem.getProduct();
                            %>
                            <tr>
                                <td class="cart_product">
    <!--                                <a href=""><img src="/PRJ301/ImagesProduct/<%=product.getImage()%>" alt=""></a>-->
                                    <a href=""><img src="/PRJ301/ImagesProduct/<%=product.getImage()%>" alt="" style="max-width: 70px; max-height: 110px;"></a>
                                </td>
                                <td class="cart_description">
                                    <h4><a href=""><%=product.getName_Product()%></a></h4>
                                    <p>Ma SP :<%=product.getID_Product()%></p>
                                </td>
                                <td class="cart_price">
                                    <p><%=nf.format(product.getUnit_price())%></p>
                                </td>
                                <td>
                                    <p><%=product.getDiscount()%> %</p>
                                </td>
                                <td class="cart_quantity">
                                    <div class="cart_quantity_button">
                                        <!-- Tăng giảm số lượng không cần thêm cartID vào URL -->
                                        <a class="cart_quantity_up" href="CartServlet?command=plus&ID_Product=<%=product.getID_Product()%>"> + </a>
                                        <input class="cart_quantity_input" type="text" value="<%=cartItem.getQuantity() %>" autocomplete="off" size="2" disabled="">
                                        <a class="cart_quantity_down" href="CartServlet?command=sub&ID_Product=<%=product.getID_Product()%>"> - </a>
                                    </div>
                                </td>
                                <td class="cart_total">
                                    <p class="cart_total_price"><%= nf.format(cartItem.getQuantity() * product.getUnit_price() - cartItem.getQuantity() * product.getUnit_price() * product.getDiscount() / 100)%> VND</p>
                                </td>
                                <td class="cart_delete">
                                    <a class="cart_quantity_delete" href="CartServlet?command=remove&ID_Product=<%=product.getID_Product()%>"><i class="fa fa-times"></i></a>
                                </td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>

        <!-- Do action section for order summary -->


        <section id="do_action">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <div class="total_area">
                            <ul>
                                <li>Tổng tiền <span><%=nf.format(cart.total()) %></span></li>
                            </ul>
                            <% if (cart.getItems() != null && !cart.getItems().isEmpty()) { %>
                            <a class="btn btn-default update" href="">Hủy đơn hàng</a>
                            <a class="btn btn-default check_out" href="PayServlet?checkoutAction=fetchCart">Thanh toán</a>
                            <% } else { %>
                            <p style="text-align: center ;color: red">Hãy chọn sản phẩm trước khi thanh toán.</p>
                            <% } %>
                        </div>
                    </div>
                </div>
            </div>
        </section>



        <!--    <section id="do_action">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="total_area">
                                <ul>
                                    <li>Tổng tiền <span><%=nf.format(cart.total()) %></span></li>
                                </ul>
                                <a class="btn btn-default update" href="">Hủy đơn hàng</a>
                                <a class="btn btn-default check_out" href="checkout.jsp">Thanh toán</a>
                                    <a class="btn btn-default check_out" href="PayServlet?checkoutAction=fetchCart">Thanh toán</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>-->

        <!-- Footer includes footer.jsp content -->
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
