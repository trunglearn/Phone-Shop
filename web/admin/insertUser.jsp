<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm mới tài khoản</title>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="left.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Thông tin tài khoản</h3>
                    <form action="/PRJ301/UpLoadUserServlet" method="Post">
                        <table width="95%">
                            <tr>
                                <td width="125px"><b>Tên tài khoản</b></td>
                                <td><input type="text" placeholder="Tên của bạn" class="pendek" name="Name_Account">
                                </td>
                            </tr>
                            <tr>
                                <td width="125px"><b>Tên đăng nhập</b></td>
                                <td><input type="email" placeholder="Địa chỉ email" class="pendek" name="Login_Name">
                                </td>
                            </tr>
                            <tr>
                                <td width="125px"><b>Mật khẩu</b></td>
                                <td><input type="password" placeholder="mật khẩu đăng nhập" class="pendek" name="password">
                                </td>
                            </tr>
                            <tr>
                                <td width="125px"><b>Quyền truy cập</b></td>
                                <td><input type="text" placeholder="Quyền" class="pendek" name="access_rights">
                                </td>
                            </tr>

                            <tr>
                                <td></td>
                                <td>

                                    <input type="submit" class="button" value="Lưu dữ liệu">
                                </td>
                            </tr>

                        </table>
                    </form>
                </div>


                <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
