<%@page import="dao.CategoryDAOImpl"%>
<%@page import="model.Category"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
    <script>
        function submitForm() {
            var form = document.getElementById("categoryForm");
            // Your validation logic goes here
            form.submit();
        }
    </script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Thông tin danh mục sản phẩm</h3>
                <form id="categoryForm" action="/PRJ301/UpLoadCategoryServlet" method="POST" onsubmit="submitForm(); return false;">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên danh mục</b></td>
                            <td><input type="text" class="pendek" name="Name_Category"></td>
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
