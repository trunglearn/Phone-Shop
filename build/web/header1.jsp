<%-- 
    Document   : header
    Created on : Apr 25, 2017, 9:06:26 PM
    Author     : ACERR
--%>

<%@page import="model.Account"%>
<%@page import="model.TypesOfNews"%>
<%@page import="dao.NewsDAO"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | E-Shopper</title>

    </head>
    <body>
        <% 
            TypesOfNewsDAOImpl typesOfNewsDAO= new TypesOfNewsDAOImpl();
              Account loggedInUser = (Account) session.getAttribute("loggedInUser");

           
        %>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> 0948287328</a></li>
                                    <li><a href="https://mail.google.com/mail"><i class="fa fa-envelope"></i>trung12082003@gmail.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="default.jsp"><img src="images/home/logo.png" alt="" /></a>
                            </div>

                        </div>
                        <div class="col-sm-8">
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <% if (session.getAttribute("username") != null) { %>
                                    <li><a href="LoginServlet?command=logout"><i class="fa fa-user"></i><%=session.getAttribute("username")%></a></li>
                                            <% } else { %>
                                    <li><a href="LoginServlet?command=logout"><i class="fa fa-user"></i></a></li>
                                            <% } %>

                                    <!--                                    <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i>Thanh toán</a></li>-->
                                    <!--                                    <li><a href="cart.jsp"><i class="fa fa-shopbatteryg-cart"></i>Giỏ hàng</a></li>-->
                                    <% if (session.getAttribute("username") != null) { %>
                                    <li><a href="cart.jsp"><i class="fa fa-shopbatteryg-cart"></i>Giỏ hàng</a></li>
                                        <% } %>
                                        <% if (session.getAttribute("username") != null && session.getAttribute("username").equals("2@gmail.com")) { %>
                                    <li><a href="admin/index.jsp"><i class="fa fa-shopbatteryg-cart"></i>Quay lại admin</a></li>
                                        <% } %>

                                    <% if (session.getAttribute("username") != null) { %>
                                    <li><a href="LoginServlet?command=logout"><i class="fa fa-user"></i>Đăng xuất</a></li>
                                        <% } else { %>
                                    <li><a href="account.jsp"><i class="fa fa-lock"></i>Đăng nhập</a></li>
                                        <% } %>


                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-9">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="default.jsp" class="active">Trang chủ</a></li>


                                    </li>
                                    <li class="dropdown"><a href="news.jsp">Tin tức<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <% 
                                                  for(TypesOfNews typesOfNew: typesOfNewsDAO.getListTypesOfNews())
                                                  {
                                            %>
                                            <li><a href="typenews.jsp?ID_Types_of_news=<%=typesOfNew.getID_Types_of_news() %>"><%=typesOfNew.getName_Types_of_news() %></a></li>
                                                <% 
                                            }%>

                                        </ul>
                                    </li> 
                                    <li><a href="contact.jsp">Liên hệ</a></li>
                                </ul>
                            </div>
                        </div>

                    </div>
                </div>
            </div><!--/header-bottom-->
        </header>

    </body>
</html>
