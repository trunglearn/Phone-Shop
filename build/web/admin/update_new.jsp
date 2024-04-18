<%@page import="model.News"%>
<%@page import="dao.NewsDAOImpl"%>
<%@page import="model.TypesOfNews"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhât tin tức</title>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="<c:url value="/ckeditor/ckeditor.js" />"></script>
    </head>
    <body>
        <% NewsDAOImpl NewsDAO = new NewsDAOImpl();
            News tt = NewsDAO.getListNewsByID(Integer.parseInt(request.getParameter("ID_News")));
        %>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">

            <jsp:include page="left.jsp"></jsp:include>

                <div id="rightContent">
                    <h3> Nhập tin tức</h3>
                    <form action="/PRJ301/UpdateNewServlet" method="POST" enctype="multipart/form-data">
                        <table width="95%">


                            <tr>
                                <td><b>Mã loại tin </b> </td>
                                <td>
                                    <select name="ID_Types_of_news" >
                                        <option selected> Lựa chọn</option>
                                    <% TypesOfNewsDAOImpl TypesOfNewsDAO = new TypesOfNewsDAOImpl();
                                        for (TypesOfNews lt : TypesOfNewsDAO.getListTypesOfNews()) {

                                    %>
                                    <option  value="<%=lt.getID_Types_of_news()%>" <% if (lt.getID_Types_of_news() == tt.getID_Types_of_news()) {
                                             %>selected="true"<%
                                             } else {%> <%
                                            }
                                             %>>
                                        <%=lt.getName_Types_of_news()%>
                                    </option>

                                    <% }%>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Tên tin tức</b></td>
                            <td><input type="text" class="pendek" name="Name_News" value="<%=tt.getName_News()%>">
                            </td>
                        </tr>



                        <tr>
                            <td width="125px"><b>Tiêu đề</b></td>
                            <td><input type="text" class="pendek" name="title" value="<%=tt.getTitle()%>">
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Nội dung</b></td>
                             <td>
                                <textarea  type="text" class="form-textarea" id="noiDung" name="content"><%=tt.getContent() %></textarea>
                                <script type="text/javascript" language="javascript">
                                    CKEDITOR.replace('noiDung', {width: '500px', height: '300px'});
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td width="125px"><b>Hình ảnh</b></td>
                            <td>
                                <input type="file" name="image" value="/PRJ301/ImagesProduct/<%=tt.getImage()%>" />
                                <img style="width: 50px;heigth:70px;" src="/PRJ301/ImagesProduct/<%=tt.getImage()%>" >
                            </td>

                        </tr>
                        <tr>
                            <td width="125px"><b>NgayDang</b></td>
                            <td><input type="text" class="pendek" name="publish_date" value="<%=tt.getPublish_date()%>">
                            </td>
                        </tr>



                        <tr><td></td><td>
                                <input type="hidden" name="ID_News" value="<%=request.getParameter("ID_News")%>">
                                <input type="submit" class="button" value="Lưu dữ liệu">


                    </table>
                </form>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
