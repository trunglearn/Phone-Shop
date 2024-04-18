<%-- 
    Document   : error
    Created on : Mar 11, 2024, 3:04:31 PM
    Author     : ACERR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Home | E-Shopper</title>
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
    <style>
        /* CSS cho hình ảnh */
        .logo-404 img {
            max-width: 100%;
            height: auto;
            margin: 0 auto;
        }

        .content-404 {
            text-align: center;
        }

        .content-404 img {
            max-width: 50%;
            height: auto;
            margin: 20px 0;
        }


    </style>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container text-center">
                <div class="logo-404">
                    <a href="index.html"><img src="images/home/logo.png" alt="" /></a>
                </div>
                <div class="content-404">
                <%
                  int errorCode = response.getStatus(); // Lấy mã lỗi từ response

                  // Hiển thị hình ảnh phù hợp với từng loại lỗi
                  if (errorCode == 400) { %>
                <img src="images/error/400.png" alt="400 Bad Request">
                <% } else if (errorCode == 401) { %>
                <img src="images/error/401.png" alt="401 Unauthorized">
                <% } else if (errorCode == 403) { %>
                <img src="images/error/403.png" alt="403 Forbidden">
                <% } else if (errorCode == 404) { %>
                <img src="images/error/404.png" alt="404 Not Found">
                <% } else if (errorCode == 500) { %>
                <img src="images/error/500.png" alt="500 Internal Server Error">
                <% } else { %>
                <p>Oops! Something went wrong. Please try again later.</p>
                <% } %>

                <h2><a href="default.jsp">Bring me back Home</a></h2>
            </div>

            <br/>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
