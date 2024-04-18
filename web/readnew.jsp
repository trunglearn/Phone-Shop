<%-- 
    Document   : typenews
    Created on : May 8, 2017, 2:59:52 PM
    Author     : ACERR
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.News"%>
<%@page import="dao.NewsDAOImpl"%>
<%@page import="model.TypesOfNews"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Tin tức</title>
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
        <%  TypesOfNewsDAOImpl TypesOfNewsDAO = new TypesOfNewsDAOImpl();
            NewsDAOImpl NewsDAO = new NewsDAOImpl();
            int ID_News = Integer.parseInt(request.getParameter("ID_News"));
            News tt = NewsDAO.getListNewsByID(ID_News);
        %>
        <jsp:include page="header.jsp"></jsp:include>
        <jsp:include page="slider.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Loại tin</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            <% for (TypesOfNews TypesOfNews : TypesOfNewsDAO.getListTypesOfNews()) {


                            %>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="typenews.jsp?ID_Types_of_news=<%=TypesOfNews.getID_Types_of_news()%>">
                                            <%=TypesOfNews.getName_Types_of_news()%>

                                        </a>
                                    </h4>
                                </div>

                            </div>
                            <%
                                }%>
                        </div>


                    </div>
                  </div>
                <div class="col-sm-9">
                    <div class="blog-post-area">
                        <h2 class="title text-center">TIN TỨC</h2>
                        <div class="single-blog-post">
                            <h3><%=tt.getName_News()%></h3>
                            <div class="post-meta">
                                <ul>

                                    <li><i class="fa fa-calendar"></i><%=tt.getPublish_date()%></li>
                                </ul>

                            </div>
                            <a href="">
                                <img style="width:30%;height: auto" src="/PRJ301/ImagesProduct/<%=tt.getImage()%>" alt="">
                            </a>
                            <p><%=tt.getContent()%></p>

                        </div>
                    </div><!--/blog-post-area-->



                    <div class="socials-share">
                        <a href=""><img src="images/blog/socials.png" alt=""></a>
                    </div><!--/socials-share-->
                </div>	
            </div>
        </div>

    </div>

</body>
</html>
