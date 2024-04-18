<%@page import="java.util.ArrayList"%>
<%@page import="model.News"%>
<%@page import="dao.NewsDAOImpl"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page import="model.TypesOfNews"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tin tức</title>
        <link rel="icon" type="image/x-icon" href="https://th.bing.com/th/id/R.e15d750fe41eb99350f0c56e6b66b653?rik=QJI66s2o67Q7jw&pid=ImgRaw&r=0">

        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
    </head>
    <body>
        <%  TypesOfNewsDAOImpl TypesOfNewsDAO = new TypesOfNewsDAOImpl();
            NewsDAOImpl NewsDAO = new NewsDAOImpl();
            ArrayList<News> arr = NewsDAO.getListNews();
            int start = 0, end = 2;
            if (arr.size() < 2) {
                end = arr.size();

            }
            if (request.getParameter("start") != null) {
                start = Integer.parseInt(request.getParameter("start"));

            }
            if (request.getParameter("end") != null) {
                end = Integer.parseInt(request.getParameter("end"));

            }
            ArrayList<News> list = NewsDAO.getListNewsByPage(arr, start, end);
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                            <h2>Loại tin</h2>
                            <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                            <% for (TypesOfNews typesOfNews : TypesOfNewsDAO.getListTypesOfNews()) {


                            %>

                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="typenews.jsp?ID_Types_of_news=<%=typesOfNews.getID_Types_of_news()%>">
                                            <%=typesOfNews.getName_Types_of_news()%>

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
                        <%  for (News tt : list) {
                        %>
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
                            <p><%=tt.getTitle()%></p>
                            <a  class="btn btn-primary" href="readnew.jsp?ID_News=<%=tt.getID_News()%>">Đọc thêm</a>
                        </div>
                        <% }%>


                        <div style="clear: both"></div>
                        <ul class="pagination">
                            <%
                                int a, b;
                                int limit = arr.size() / 3;
                                if (limit * 2 < arr.size()) {
                                    limit += 1;
                                }
                                for (int i = 1; i <= limit; i++) {
                                    a = (i - 1) * 3;
                                    b = i * 3;
                                    if (b > arr.size()) {
                                        b = arr.size();
                                    }

                            %>
                            <li class="active"><a href="news.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                                <% }
                                %>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
