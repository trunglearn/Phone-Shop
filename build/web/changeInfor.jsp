<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Account"%>
<%@page import="dao.AccountDAOImpl"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Cập nhật thông tin</title>
                <link rel="icon" type="image/x-icon" href="https://th.bing.com/th/id/R.e15d750fe41eb99350f0c56e6b66b653?rik=QJI66s2o67Q7jw&pid=ImgRaw&r=0">
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

/* Thiết lập style cho khung sửa */
#rightContent {
    background-color: #fff;
    padding: 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    margin: 0 auto; /* Căn giữa khung sửa trên trang */
    width: 50%; /* Thiết lập chiều rộng của khung sửa */
}
/* Thiết lập style cho tiêu đề */
#rightContent h3 {
    color: #333;
    font-size: 24px;
    margin-bottom: 20px;
}

/* Thiết lập style cho bảng thông tin */
#rightContent table {
     margin: 0 auto;
    width: 100%;
    border-collapse: collapse;
    margin-bottom: 20px;
}

#rightContent table, #rightContent th, #rightContent td {
    border: 1px solid #ddd;
}

#rightContent th, #rightContent td {
    padding: 8px;
    text-align: left;
}

#rightContent th {
    background-color: #f2f2f2;
    color: #333;
}

/* Thiết lập style cho input */
#rightContent input[type="text"] {
    width: calc(100% - 16px);
    padding: 8px;
    margin-top: 5px;
    margin-bottom: 15px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 3px;
}

/* Thiết lập style cho button */
#rightContent .button {
    background-color: #fdb45e;
    color: white;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin-top: 10px;
}

#rightContent .button:hover {
    background-color: #EDEFF6;
}


    </style>
    <body>
        <%

            AccountDAOImpl tkDao = new AccountDAOImpl();
            String username = (String) session.getAttribute("username");
          
       System.out.println(username);
            Account tk = tkDao.getInfoAccount(username);
              System.out.println(tk);
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">

                <div id="rightContent">
                    <h3>Thông tin tài khoản</h3>
                    <form action="/PRJ301/ChangeServlet" method="POST">
                        <table width="95%">
                            <tr>
                                <td width="125px"><b>Tên tài khoản</b></td>
                                <td><input type="text" class="pendek" name="Name_Account" value="<%=tk.getName_Account()%>" >
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Tên đăng nhập</b></td>
                            <td><input type="text" class="pendek" name="Login_Name"  readonly value="<%=tk.getLogin_Name()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Trạng thái</b></td>
                            <td><input type="text" class="pendek" name="Status" value="<%=tk.getStatus()%>">
                            </td>
                        </tr>


                        <tr>
                            <td></td>
                            <td>
                                <input type="hidden" name="ID_Account" value="<%=tk.getID_Account()%>">
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
