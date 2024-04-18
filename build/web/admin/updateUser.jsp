

<%@page import="model.Account"%>
<%@page import="dao.AccountDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cập nhật thông tin tài khoản </title>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
    </head>
    <body>
        <%
            AccountDAOImpl tkDao = new AccountDAOImpl();
            int ID_Account = Integer.parseInt(request.getParameter("ID_Account"));
            Account tk = tkDao.getAccountByIDAccount(ID_Account);
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="left.jsp"></jsp:include>
                <div id="rightContent">
                    <h3>Thông tin tài khoản</h3>
                    <form action="/PRJ301/UpdateAccountServlet" method="POST">
                        <table width="95%">
                            <tr>
                                <td width="125px"><b>Tên tài khoản</b></td>
                                <td><input type="text" class="pendek" name="Name_Account" value="<%=tk.getName_Account()%>" >
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Tên đăng nhập</b></td>
                            <td><input type="text" class="pendek" name="Login_Name" value="<%=tk.getLogin_Name()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Mật khẩu</b></td>
                            <td><input type="text" class="pendek" name="Password" value="<%=tk.getPassword()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Quyền truy cập</b></td>
                            <td><input type="text" class="pendek" name="Access_rights" value="<%=tk.getAccess_rights()%>">
                            </td>
                        </tr>

                        <tr>
                            <td></td>
                            <td>
                                <input type="hidden" name="ID_Account" value="<%=request.getParameter("ID_Account")%>">
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
