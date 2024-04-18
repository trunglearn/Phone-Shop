<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Thông tin cá nhân</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/price-range.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <link rel="stylesheet" href="css/personal.css">
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/main.js"></script>
    </head>
    <style>
        body {
            font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
            background-color: #f8f9fa; /* A neutral off-white background */
            margin: 0;
            padding: 0;
        }

        .personal-info {
            margin-top: 50px;
            background-color: #ffffff; /* White background for the card */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1); /* Smooth shadow to give depth */
            max-width: 600px;
            margin: 50px auto; /* Center the card on the page */
            border: 1px solid #e0e0e0; /* Subtle border color */
        }

        .personal-info h2 {
            margin-bottom: 30px;
            text-align: center;
            font-size: 28px;
            color: #4a4a4a; /* Dark gray for the title */
            font-weight: 500; /* Semi-bold for the title */
        }

        .personal-info .form-group {
            margin-bottom: 25px;
            display: flex;
            align-items: center;
        }

        .personal-info label {
            font-weight: 500; /* Semi-bold for the labels */
            color: #5e5e5e; /* Slightly lighter than the title for contrast */
            flex-basis: 30%; /* Allocate space for labels */
            text-align: right;
            padding-right: 15px;
            margin-bottom: 0; /* Override bootstrap styles */
        }

        .personal-info .form-control-static {
            font-size: 16px;
            line-height: 1.5;
            flex-basis: 70%; /* Allocate space for content */
            text-align: left;
            padding: 8px 16px; /* Padding inside the content boxes */
            background-color: #f7f7f7; /* Light grey background for the content */
            border: 1px solid #d1d1d1; /* Matching border for content boxes */
            border-radius: 5px; /* Rounded borders for the content boxes */
            margin-left: 15px; /* Space between label and content */
            box-shadow: inset 0 2px 2px rgba(0,0,0,0.05); /* Inner shadow for depth */
            transition: all 0.2s; /* Smooth transition for interactions */
        }

        .personal-info .form-control-static:hover {
            background-color: #e9ecef; /* Lighter grey on hover for an interactive effect */
            border-color: #cacaca; /* Darker border on hover for contrast */
        }
    </style>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 personal-info">
                        <h2>Thông tin cá nhân</h2>
                        <div class="form-horizontal" role="form">
                            <div class="form-group">
                                <label class="col-lg-3 control-label">Tên tài khoản:</label>
                                <div class="col-lg-8">
                                    <p class="form-control-static"><%= session.getAttribute("Name_Account") %></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Tên đăng nhập:</label>
                            <div class="col-lg-8">
                                <p class="form-control-static" readonly><%= session.getAttribute("Login_Name") %></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-3 control-label">Trạng thái:</label>
                            <div class="col-lg-8">
                                <p class="form-control-static"><%= session.getAttribute("Status") %></p>
                            </div>
                        </div>
                    </div>
                    <a href="ChangeServlet?command=change">Nhấn vào đây để cập nhật thông tin</a>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
