<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | E-Shopper</title>
    </head>
    <%@page import="model.Cart"%>
    <%@page import="java.text.NumberFormat"%>
    <%@page import="model.Product"%>
    <%@page import="dao.ProductDAOImpl"%>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Home | E-Shopper</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>

    </head>
    <body>
        <%
            ProductDAOImpl productDAO = new ProductDAOImpl();
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMinimumIntegerDigits(0);

            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                session.setAttribute("cart", cart);
            }
            ArrayList<Product> arr = productDAO.getListProduct();
            int start = 0, end = 9;
            if (arr.size() < 9) {
                end = arr.size();

            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));

            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));

            }
            ArrayList<Product> list = productDAO.getListProductByPage(arr, start, end);


        %>
        <div class="col-sm-9 padding-right">
            <div class="features_items"><!--features_items-->
                <h2 class="title text-center">Sản phẩm mới</h2>
                <%                    for (Product sp : list) {
                %>

                <div class="col-sm-4">
                    <div class="product-image-wrapper">
                        <div class="single-products">
                            <div class="productinfo text-center">
                                <img src="/PRJ301/ImagesProduct/<%=sp.getImage()%>" alt="" />
                                <h2><%=nf.format(sp.getUnit_price())%> VND</h2>
                                <p><%=sp.getName_Product()%></p>
                                <a href="CartServlet?command=insert&ID_Product=<%=sp.getID_Product()%>&cartID=<%=System.currentTimeMillis()%>" class="btn btn-default add-to-cart">
                                    <i class="fa fa-shopbatteryg-cart"></i>Thêm vào giỏ hàng</a>
                            </div>
                            <div class="product-overlay">
                                <div class="overlay-content">
                                    <h2><%=nf.format(sp.getUnit_price())%>VND</h2>
                                    <p><%=sp.getName_Product()%></p>
                                    <a href="CartServlet?command=insert&ID_Product=<%=sp.getID_Product()%>&cartID=<%=System.currentTimeMillis()%>" class="btn btn-default add-to-cart">
                                        <i class="fa fa-shopbatteryg-cart"></i>Thêm vào giỏ hàng</a>
                                </div>
                            </div>
                        </div>
                        <div class="choose">
                            <ul class="nav nav-pills nav-justified">
                                
                                <li><a href="detail.jsp?ID_Product=<%=sp.getID_Product()%>"><i class="fa fa-plus-square"></i>Xem chi tiết</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <% }%>
                
                <div style="clear: both"></div>
                <ul class="pagination">
                    <%
                        int a, b;
                        int limit = arr.size() / 9;
                        if (limit * 9 < arr.size()) {
                            limit += 1;
                        }
                        for (int i = 1; i <= limit; i++) {
                            a = (i - 1) * 9;
                            b = i * 9;
                            if (b > arr.size()) {
                                b = arr.size();
                            }

                    %>
                    <li class="active"><a href="default.jsp?start=<%=a%>&end=<%=b%> "><%=i %></a></li>
                        <% }
                        %>
                </ul>


            </div><!--features_items-->





        </div>
    </body>
</html>
