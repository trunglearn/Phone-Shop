<%-- 
    Document   : insert_typenews
    Created on : May 10, 2017, 11:39:25 PM
    Author     : ACERR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <title>Thêm danh mục</title>
   <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Thông tin </h3>
                <form action="/PRJ301/UpLoadTypeNewServlet" method="POST">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên danh loại tin</b></td>
                            <td><input type="text" class="pendek" name="TenTypesOfNews">
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
