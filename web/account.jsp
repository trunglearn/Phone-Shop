

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title> Đăng nhập, đăng ký thành viên</title>
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

    </head>
    <body>
        <% String NameAccount_err="",Username_err="",Password_err="";
        if(request.getAttribute("NameAccount_err")!=null)
        {
            NameAccount_err=(String)request.getAttribute("NameAccount_err");
        }
        if(request.getAttribute("Username_err")!=null)
        {
            Username_err=(String)request.getAttribute("Username_err");
        }
        if(request.getAttribute("Password_err")!=null )
        {
            Password_err=(String)request.getAttribute("Password_err");
        }
        String NameAccount="",Username="",Password="";
        if(request.getAttribute("NameAccount")!=null)
        {
            NameAccount=(String)request.getAttribute("NameAccount");
        }
        if(request.getAttribute("Username")!=null)
        {
            Username=(String)request.getAttribute("Username");
        }
        if(request.getAttribute("Password")!=null )
        {
            Password=(String)request.getAttribute("Password");
        }
        String err="";
        if(request.getAttribute("err")!=null)
        {
            err=(String) request.getAttribute("err");
            
        }
        %>
        <jsp:include page="header1.jsp"></jsp:include>
            <section id="form"><!--form-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-1">
                            <div class="login-form"><!--login form-->
                                <h2>Đăng nhập</h2>
                                <form action="LoginServlet" method="POST">
                                    <p style="color:red"><%=err  %></p>
                                <input type="email" placeholder="Địa chỉ Email đăng nhập" name="Username" />
                                <input type="password" placeholder="Mật khẩu đăng nhập" name="Password" />

                                <button type="submit" class="btn btn-default">Đăng nhập</button>
                            </form>
                        </div><!--/login form-->
                    </div>
                    <div class="col-sm-1">
                        <h2 class="or">Hoặc</h2>
                    </div>
                    <div class="col-sm-4">
                        <div class="signup-form"><!--sign up form-->
                            <h2>Đăng ký tài khoản mới!</h2>
                            <form action="RegisterServlet" method="POST">
                                <p style="color:red"><%=NameAccount_err %></p>
                                <input type="text" placeholder="Họ và tên" name="LoginName" value="<%=NameAccount %>"/>
                                <p style="color:red"><%=Username_err %></p>
                                <input type="email" placeholder="Địa chỉ Email đăng ký" name="Username" value="<%=Username %>"/>
                                <p style="color:red"><%=Password_err %></p>
                                <input type="password" placeholder="Mật khẩu đăng nhập" name="Password" value="<%=Password %>"/>
                                <button type="submit" class="btn btn-default">Đăng ký</button>
                            </form>
                        </div><!--/sign up form-->
                    </div>
                </div>
            </div>
        </section>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
