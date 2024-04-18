

<%@page import="java.util.ArrayList"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
    <!-- Thêm link Bootstrap 3 từ CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý danh mục</h3>
                <div>
                <%=request.getAttribute("msgDelete") != "" ? request.getAttribute("msgDelete") : "Hello"%>
                <div>
                    <% if (request.getAttribute("msgDelete") != null) { %>
                    <%= request.getAttribute("msgDelete") %>
                    <% } %>
                </div>

            </div>
            <p><a href="/PRJ301/admin/insert_category.jsp">Thêm danh mục</a></p>                 
            <table class="data">
                <tr class="data">
                    <th class="data" width="30px">STT</th>
                    <th class="data">Mã danh mục</th>
                    <th class="data">Tên danh mục</th>

                    <th class="data" width="75px">Tùy chọn</th>
                </tr>
                <%CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();
                    ArrayList<Category> arr =CategoryDAO.getListCategory();
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
                    ArrayList<Category> list =CategoryDAO.getListCategoryByPage(arr, start, end);
                    int count = 0;
                    for (Category dm : list) {
                        count++;
                %>
                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=dm.getID_Category()%></td>
                    <td class="data"><%=dm.getName_Category()%></td>

                    <td class="data" width="75px">
                <center>
                    <a href="/PRJ301/admin/update_category.jsp?ID_Category=<%=dm.getID_Category()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <!-- Thêm nút xóa và modal -->
                    <a href="#" data-toggle="modal" data-target="#deleteModal<%=dm.getID_Category()%>">Xóa</a>

                    <!-- Modal xác nhận xóa -->
                    <div class="modal fade" id="deleteModal<%=dm.getID_Category()%>" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
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
                                    <a href="/PRJ301/DeleteCategoryServlet?ID_Category=<%=dm.getID_Category()%>" class="btn btn-danger">Xóa</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </center>
                </td>
                </tr>
                <% }%>





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
                <li ><a href="/PRJ301/admin/manager_category.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
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
