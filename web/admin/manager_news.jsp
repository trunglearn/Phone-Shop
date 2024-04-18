<%@page import="java.util.ArrayList"%>
<%@page import="model.News"%>
<%@page import="dao.NewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quản lý loại tin tức</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<style>


</style>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý tin tức</h3>

                <p><a href="insert_new.jsp">Thêm tin tức</a></p>                 
                <table class="data">
                    <tr class="data">
                        <th class="data" width="30px">STT</th>
                        <th class="data">Mã tin</th>
                        <th class="data">Mã loại tin</th>
                        <th class="data">Tên tin</th>
                        <th class="data">Tiêu đề</th>
                        <th class="data">Nội dung</th>
                        <th class="data">Hình ảnh</th>
                        <th class="data">Ngày đăng</th>

                        <th class="data" width="75px">Tùy chọn</th>
                    </tr>
                <%  NewsDAOImpl NewsDAOImpl = new NewsDAOImpl();
                    ArrayList<News> arr = NewsDAOImpl.getListNews();
                    int start = 0, end = 9;
                    if (arr.size() < 9) {
                        end = arr.size();

                    }
                    if (request.getParameter("start") != null) {
                        start = Integer.parseInt(request.getParameter("start"));

                    }
                    if (request.getParameter("end") != null) {
                        end = Integer.parseInt(request.getParameter("end"));

                    }
                    ArrayList<News> list = NewsDAOImpl.getListNewsByPage(arr, start, end);
                    int count = 0;
                    for (News tt : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=tt.getID_News()%></td>
                    <td class="data"><%=tt.getID_Types_of_news()%></td>
                    <td class="data"><%=tt.getName_News()%></td>
                    <td class="data"><%=tt.getTitle()%></td>
                    <td class="data"><%=tt.getContent()%></td>
                    <td class="data"><img style="width: 200px;heigth:150px;" src="/PRJ301/ImagesProduct/<%=tt.getImage()%>"</td>
                    <td class="data"><%=tt.getPublish_date()%></td>
                    <td class="data" width="75px">
                <center>
                    <a href="/PRJ301/admin/update_new.jsp?ID_News=<%=tt.getID_News()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <!-- Thêm nút xóa và modal -->
                    <a href="#" data-toggle="modal" data-target="#deleteModal<%=tt.getID_News()%>">Xóa</a>

                    <!-- Modal xác nhận xóa -->
                    <div class="modal fade" id="deleteModal<%=tt.getID_News()%>" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="deleteModalLabel">Xác nhận xóa</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Bạn có chắc chắn muốn xóa loại tin tức này không?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                                    <a href="/PRJ301/DeleteNewServlet?ID_News=<%=tt.getID_News()%>" class="btn btn-danger">Xóa</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </center>
                </td>
                </tr>
                <%
                    }%>
            </table>
            <ul class="pagination">
                <%
                    int a, b;
                    int limit = arr.size() / 9;
                    if (limit * 9 < arr.size()) {
                        limit += 1;
                    }
                    for (int i = 1; i <= limit; i++) {
                        a = (i - 1) * 9;
                        b = i * 9;
                        if (b > arr.size()) {
                            b = arr.size();
                        }

                %>
                <li ><a href="/PRJ301/admin/manager_news.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
                    <% }
                    %>
            </ul>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <!-- Thêm các script để hỗ trợ Bootstrap -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body> 
</html>
