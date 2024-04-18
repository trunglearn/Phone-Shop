<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImpl"%>
<%@ page import="java.math.BigDecimal" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
    <% ProductDAOImpl spdao = new ProductDAOImpl();
        ArrayList<Product> arr = spdao.getListProduct();
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
        ArrayList<Product> list = spdao.getListProductByPage(arr, start, end);
    %>

    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý sản phẩm</h3>

                <p><a href="insert_product.jsp">Thêm sản phẩm mới</a></p>                 
                <table class="data"style="width:1200px" >
                    <tr class="data" style="width:1000px">
                        <th class="data" width="30px">STT</th>
                        <th class="data"width="200px" >Mã sản phẩm</th>
                        <th class="data" width="200px">Tên sản phẩm</th>
                        <th class="data" width="200px">Mã danh mục</th>
                        <th class="data" width="200px">Hình ảnh</th>
                        <th class="data"width="200px">Số lượng</th>
                        <th class="data"width="200px">Đơn giá</th>
                        <th class="data"width="200px">Giảm giá</th>
                        <th class="data"width="200px">Màn hình</th>
                        <th class="data"width="200px">Camera trước</th>
                        <th class="data"width="200px">Camera sau</th>
                        <th class="data"width="200px">Hệ điều hành</th>
                        <th class="data"width="200px">CPU</th>
                        <th class="data"width="200px">Ram</th>
                        <th class="data"width="200px">Kết nối</th>
                        <th class="data"width="200px">PinSac</th>
                        <!--                        <th class="data" width="200px">Bảo hành</th>-->
                        <th class="data"width="200px">Mô tả</th>

                        <th class="data" width="400px">Tùy chọn</th>
                    </tr>
                <% ProductDAOImpl ProductDAO = new ProductDAOImpl();
                    int count = 0;
                    for (Product sp : list) {
                        count++;
                %>

                <tr class="data">
                    <td class="data" width="30px"><%=count%></td>
                    <td class="data"><%=sp.getID_Product()%></td>
                    <td class="data"><%=sp.getName_Product()%></td>
                    <td class="data"><%=sp.getID_Category()%></td>
                    <td class="data"><img style="width: 50px;heigth:70px;" src="/PRJ301/ImagesProduct/<%=sp.getImage()%>" ></td>
                    <td class="data"><%=sp.getQuantity()%></td>
<!--                    <td class="data"><%=sp.getUnit_price()%></td>-->
                    <td class="data"><%= new BigDecimal(sp.getUnit_price()).intValue() %></td>
                    <td class="data"><%=sp.getDiscount()%></td>
                    <td class="data"><%=sp.getDisplay()%></td>
                    <td class="data"><%=sp.getFront_camera()%></td>
                    <td class="data"><%=sp.getRear_camera()%></td>
                    <td class="data"><%=sp.getOperating_system()%></td>
                    <td class="data"><%=sp.getCpu()%></td>
                    <td class="data"><%=sp.getRam()%></td>
                    <td class="data"><%=sp.getCpu()%></td>
                    <td class="data"><%=sp.getBattery()%></td>

                    <td class="data"><%=sp.getDescription()%></td>
                    <td class="data" width="75px">
                <center>

                    <a href="/PRJ301/admin/update_product.jsp?ID_Product=<%=sp.getID_Product()%>">Sửa</a>&nbsp;||&nbsp;&nbsp;
                    <!-- Thêm nút xóa và modal -->
                    <a href="#" data-toggle="modal" data-target="#deleteModal<%=sp.getID_Product()%>">Xóa</a>

                    <!-- Modal xác nhận xóa -->
                    <div class="modal fade" id="deleteModal<%=sp.getID_Product()%>" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel" aria-hidden="true">
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
                                    <a href="/PRJ301/DeleteProductServlet?ID_Product=<%=sp.getID_Product()%>"class="btn btn-danger">Xóa</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </center>
                </td>
                </tr>

                <% }
                %>


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
                <li ><a href="/PRJ301/admin/manager_product.jsp?start=<%=a%>&end=<%=b%> "><%=i%></a></li>
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
