<%-- 
    Document   : contact
    Created on : Apr 25, 2017, 10:26:11 PM
    Author     : ACERR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Liên hệ</title>
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
        <jsp:include page="header.jsp"></jsp:include>
            <div id="contact-page" class="container">
                <div class="bg">
                    	
                    <div class="row">  	
                        <div class="col-sm-8">
                            <div class="contact-form">
                                <h2 class="title text-center">Liên hệ</h2>
                                <div class="status alert alert-success" style="display: none"></div>
                                <form action="SendMessageServlet" method="post">
                                    <div class="form-group col-md-6">
                                        <input type="text" name="name" class="form-control" required="required" placeholder="Tên">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <input type="email" name="email" class="form-control" required="required" placeholder="Email của bạn">
                                    </div>
                                    <div class="form-group col-md-12">
                                        <input type="text" name="subject" class="form-control" required="required" placeholder="Tiêu đề">
                                    </div>
                                    <div class="form-group col-md-12">
                                        <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Nội dung"></textarea>
                                    </div>                        
                                    <div class="form-group col-md-12">
                                        <input type="submit" name="submit" class="btn btn-primary pull-right" value="Gửi">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <div class="contact-info">
                                <h2 class="title text-center">Thông tin liên hệ</h2>
                                <address>
                                    <p>PhoneShop Inc.</p>
                                    <p>Thạch Thất - Hà Nội</p>                                   
                                    <p>Điện thoại : 0948287328</p>
                                    <p>Email:trung12082003@gmail.com</p>
                                </address>
                                <div class="social-networks">
                                    <h2 class="title text-center">Mạng xã hội</h2>
                                    <ul>
                                        <li>
                                            <a href="https://www.facebook.com/denny.elision.3?locale=vi_VN"><i class="fa fa-facebook"></i></a>
                                        </li>
                                       
                                        <li>
                                            <a href="https://www.youtube.com"><i class="fa fa-youtube"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>    			
                    </div>  
                </div>	
            </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
