
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | E-Shopper</title>
        <link rel="icon" type="image/x-icon" href="https://th.bing.com/th/id/R.e15d750fe41eb99350f0c56e6b66b653?rik=QJI66s2o67Q7jw&pid=ImgRaw&r=0">
    </head>
    <body>
        <%
            CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        %>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Danh mục điện thoại</h2>
                <div class="well panel-group category-products" id="accordian"><!--category-productsr-->

                    <%
                        for (Category category : categoryDAO.getListCategory()) {

                    %>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="index.jsp?ID_Category=<%=category.getID_Category() %>">

                                    <%=category.getName_Category()%>
                                </a>
                            </h4>
                        </div>

                    </div>
                    <% }%>


                </div><!--/category-products-->

                <div class="price-range"><!--price-range-->
                    <h2>Giá sản phẩm</h2>
                    <div class="well">
                        <ul>
                            <li><a href="price.jsp?price1=0&price2=1000000">0-10000 VND</li>
                            <li><a href="price.jsp?price1=1000000&price2=3000000">10000-3000000 VND</li>
                            <li><a href="price.jsp?price1=3000000&price2=5000000">30000-5000000 VND</a></li>
                            <li><a href="price.jsp?price1=5000000&price2=7000000">50000-7000000 VND</a></li>
                            <li><a href="price.jsp?price1=7000000&price2=10000000">70000-1000000 VND</a></li>
                            <li><a href="price.jsp?price1=7000000&price2=15000000">100000-1500000 VND</a></li>
                            <li><a href="price.jsp?price1=15000000&price2=30000000">150000-3000000 VND</a></li>
                        </ul>


                    </div>

                </div>


                <div class="shipbatteryg text-center"><!--shipbatteryg-->
                    <a href="shiper.jsp">  <img src="images/home/shipbatteryg.jpg" alt="" /></a>
                </div><!--/shipbatteryg-->
                <br/>

            </div>
        </div>
    </body>
</html>
