
<%@page import="dao.CategoryDAOImpl"%>
<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Cập nhật thông tin danh mục sản phẩm</h3>
                <form action="/PRJ301/UpdateCategoryServlet" method="POST">
                    <table width="95%">
                    <% CategoryDAOImpl danh_mucdao = new CategoryDAOImpl();
                        Category dm = new Category();
                        dm = danh_mucdao.getCategory(Integer.parseInt(request.getParameter("ID_Category")));
                    %>
                    <tr>
                        <td width="125px"><b>Tên danh mục</b></td>
                        <td><input type="text" class="pendek" name="Name_Category" value="<%=dm.getName_Category()%>"></td></tr>

                   
                    <tr><td></td><td>
                            <input type="hidden" name="ID_Category" value="<%=request.getParameter("ID_Category") %>">
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
