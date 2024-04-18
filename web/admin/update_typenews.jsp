
<%@page import="model.TypesOfNews"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="left.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>Cập nhật thông tin danh mục sản phẩm</h3>
                    <form action="/PRJ301/UpdateTypeNewServlet" method="POST">
                        <table width="95%">
                        <%  TypesOfNewsDAOImpl TypesOfNewsDAO= new TypesOfNewsDAOImpl();
                        TypesOfNews ID_Types_of_news= new TypesOfNews();
                   ID_Types_of_news = TypesOfNewsDAO.getTypesOfNews(Integer.parseInt(request.getParameter("ID_Types_of_news")));
                       
                        %>
                        <tr>
                            <td width="125px"><b>Tên danh mục</b></td>
                            <td><input type="text" class="pendek" name="Name_Types_of_news" value="<%=ID_Types_of_news.getName_Types_of_news() %>"></td></tr>


                        <tr><td></td><td>
                                <input type="hidden" name="ID_Types_of_news" value="<%=request.getParameter("ID_Types_of_news") %>">
                                <input type="submit" class="button" value="Lưu dữ liệu">
                            </td>
                        </tr>

                    </table>
                </form>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
