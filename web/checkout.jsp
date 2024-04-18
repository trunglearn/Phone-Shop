<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.Cart"%>
<%@page import="model.CartItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Thanh toan</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/prettyPhoto.css" rel="stylesheet">
    <link href="css/price-range.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
    <script src="js/jquery.prettyPhoto.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
    <% 
        try {
            String dia_chi_erro = "";
            String phuong_thuc_erro = "";

            if (request.getAttribute("dia_chi_erro") != null) {
                dia_chi_erro = (String) request.getAttribute("dia_chi_erro");
            }

            if (request.getAttribute("phuong_thuc_erro") != null) {
                phuong_thuc_erro = (String) request.getAttribute("phuong_thuc_erro");
            }

            // Get cart from request attribute
            Cart cart = (Cart) request.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            List<CartItem> cartItems = cart.getItems();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);
    %>

    <jsp:include page="header1.jsp"></jsp:include>

    <section id="cart_items">
        <div class="container">
            <div class="review-payment">
                <h2>Thông tin đơn hàng</h2>
            </div>
            <div class="table-responsive cart_info">
                <table class="table table-condensed">
                    <thead>
                        <tr class="cart_menu">
                            <td class="image">Sản phẩm</td>
                            <td class="description"></td>
                            <td class="price">Giá</td>
                            <td class="price">Giảm giá</td>
                            <td class="quantity">Số Lượng</td>
                            <td class="total">Thành tiền</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (CartItem cartItem : cartItems) {
                            Product product = cartItem.getProduct();
                        %>
                        <tr>
                            <td class="cart_product">
                                <a href=""><img src="/PRJ301/ImagesProduct/<%=product.getImage()%>" alt="" style="max-width: 70px; max-height: 110px;"></a>
                            </td>
                            <td class="cart_description">
                                <h4><a href=""><%=product.getName_Product()%></a></h4>
                                <p>Ma SP: <%=product.getID_Product()%></p>
                            </td>
                            <td class="cart_price">
                                <p><%=nf.format(product.getUnit_price())%></p>
                            </td>
                            <td>
                                <p><%=product.getDiscount()%> %</p>
                            </td>
                            <td class="cart_quantity">
                                <div class="cart_quantity_button">
                                    <a class="cart_quantity_up" href="CartServlet?command=plus&ID_Product=<%=product.getID_Product()%>&cartID=<%=cart.getCartID()%>"> + </a>
                                    <input class="cart_quantity_input" type="text" value="<%=cartItem.getQuantity()%>" autocomplete="off" size="2" disabled="">
                                    <a class="cart_quantity_down" href="CartServlet?command=sub&ID_Product=<%=product.getID_Product()%>&cartID=<%=cart.getCartID()%>"> - </a>
                                </div>
                            </td>
                            <td class="cart_total">
                                <p class="cart_total_price"><%= nf.format(cartItem.getQuantity() * product.getUnit_price())%> VND</p>
                            </td>
                            <td class="cart_delete">
                                <a class="cart_quantity_delete" href="CartServlet?command=remove&ID_Product=<%=product.getID_Product()%>&cartID=<%=cart.getCartID()%>"><i class="fa fa-times"></i></a>
                            </td>
                        </tr>
                        <% } %>
                        <tr>
                            <td colspan="4">&nbsp;</td>
                            <td colspan="2">
                                <table class="table table-condensed total-result">
                                    <tr>
                                        <td>Tổng tiền</td>
                                        <td><span><%=nf.format(cart.total())%></span></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="shopper-informations">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="shopper-info">
                            <p>Thông tin thanh toán</p>
                            <form action="PayServlet" method="POST">
                                <p style="color:red"><%=dia_chi_erro%></p>
                                <p> Địa chỉ giao hàng</p>
                                <textarea name="Delivery_address" rows="5"></textarea>
                                <p> Số điện thoại</p>
                                <input type="number" name="Phone"/>
                                <p> Phương thức thanh toán </p>  
                                <select name="Payment_method">
                                    <option value="Thanh toán khi giao hàng">Thanh toán khi giao hàng</option>
                                    <option value="Chuyển khoản">Chuyển khoản</option>
                                </select>
                                <input type="hidden" name="cartID" value="<%=cart.getCartID()%>"/>
                                <input type="submit" value="Xác nhận đặt hàng" class="btn btn-primary">
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <jsp:include page="footer.jsp"></jsp:include>
    <% 
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</body>
</html>
