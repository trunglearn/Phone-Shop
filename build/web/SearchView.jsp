
<%@page import="java.text.NumberFormat"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       


    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="slider.jsp"></jsp:include>
            <section>
                <div class="container">
                    <div class="row">
                    <jsp:include page="category.jsp"></jsp:include>
                        <div class="col-sm-9 padding-right">
                            <div class="features_items"><!--features_items-->
                                <h2 class="title text-center">SẢN PHẨM TÌM THẤY</h2>

                            <%
                         ProductDAOImpl spdao = new ProductDAOImpl();
                         ArrayList<Product> productList = (ArrayList<Product>) request.getAttribute("productList");
                         NumberFormat nf = NumberFormat.getInstance();
                         nf.setMinimumIntegerDigits(0);
                         if (productList != null) {
                             for (Product sp : productList) {
                            %>
                            <div class="col-sm-4">
                                <div class="product-image-wrapper">
                                    <div class="single-products">
                                        <div class="productinfo text-center">
                                            <a href="detail.jsp?ID_Product=<%=sp.getID_Product()%>"> <img src="/PRJ301/ImagesProduct/<%=sp.getImage()%>" alt="" /></a>
                                            <h2><%=nf.format(sp.getUnit_price())%> VND</h2>
                                            <p><%=sp.getName_Product()%></p>
                                            <a href="CartServlet?command=insert&ID_Product=<%=sp.getID_Product()%>&cartID=<%=System.currentTimeMillis() %>" class="btn btn-default add-to-cart">
                                                <i class="fa fa-shopbatteryg-cart"></i>Thêm vào giỏ hàng</a>
                                        </div>

                                    </div>
                                    <div class="choose">
                                        <ul class="nav nav-pills nav-justified">
                                            <li><a href="#"><i class="fa fa-plus-square"></i>So sánh</a></li>
                                            <li><a href="detail.jsp?ID_Product=<%=sp.getID_Product()%>"><i class="fa fa-plus-square"></i>Xem chi tiết</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <% }}
                            %>



                        </div>
                    </div>
                </div>
        </section>

        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
