<%@page import="model.Product"%>
<%@page import="dao.ProductDAOImpl"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAOImpl"%>
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
    <% ProductDAOImpl productDAO = new ProductDAOImpl();
        Product sp = new Product();
        sp = productDAO.getInforProduct(Integer.parseInt(request.getParameter("ID_Product")));
    %>
    <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Thông tin sản phẩm</h3>
                <form action="/PRJ301/UpdateProductServlet" method="POST" enctype="multipart/form-data">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên sản phẩm</b></td>
                            <td><input type="text" class="pendek" name="Name_Product" value="<%=sp.getName_Product()%>">
                        </td>
                    </tr>

                    <tr>
                        <td><b>Mã danh mục</b> </td>
                        <td>
                            <select name="ID_Category" >
                                <option selected> Lựa chọn</option>
                                <%CategoryDAOImpl categoryDAO= new CategoryDAOImpl();
                                    for (Category dm :categoryDAO.getListCategory()) {

                                %>
                                <option  value="<%=dm.getID_Category()%>" <% if (dm.getID_Category() == sp.getID_Category()) {
                                         %>selected="true"<%
                                        } else {%> <%
                                             }
                                         %>>
                                    <%=dm.getName_Category()%>
                                </option>

                                <% }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hình ảnh</b></td>
                        <td>
                            <input type="file" name="image" value="<%=sp.getImage() %>"/>
                        </td>

                    </tr>

                    <tr>
                        <td width="125px"><b>Số lượng</b></td>
                        <td><input type="number" class="pendek" name="quantity" value="<%=sp.getQuantity()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Đơn giá</b></td>
                        <td><input type="number" class="pendek" name="unit_price" value="<%=(int)sp.getUnit_price()%>">  VND
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b> Giảm giá</b></td>
                        <td><input type="number" class="pendek" name="discount" value="<%=(int)sp.getDiscount()%>"> %
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Màn hình</b></td>
                        <td><input type="text" class="pendek" name="display" value="<%=sp.getDisplay()%>" >
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Camera sau</b></td>
                        <td><input type="text" class="pendek" name="rear_camera" value="<%=sp.getRear_camera()%>">
                        </td>
                    </tr>


                    <tr>
                        <td width="125px"><b>Camera trước</b></td>
                        <td><input type="text" class="pendek" name="front_camera" value="<%=sp.getFront_camera()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hệ điều hành</b></td>
                        <td><input type="text" class="pendek" name="operating_system" value="<%=sp.getOperating_system()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Cpu</b></td>
                        <td><input type="text" class="pendek" name="cpu" value="<%=sp.getCpu()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Bộ nhớ</b></td>
                        <td><input type="text" class="pendek" name="memory" value="<%=sp.getMemory()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Ram</b></td>
                        <td><input type="text" class="pendek" name="ram" value="<%=sp.getRam()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Kết nối</b></td>
                        <td><input type="text" class="pendek" name="connectivity" value="<%=sp.getConnectivity()%>">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Pin sạc</b></td>
                        <td><input type="text" class="pendek" name="battery" value="<%=sp.getBattery()%>">
                        </td>
                    </tr>

                    <tr>
                        <td width="125px"><b>Mô tả</b></td>
                        <td><input type="text" class="pendek" name="description" value="<%=sp.getDescription()%>">
                        </td>
                    </tr>



                    <tr><td></td><td>
                            <input type="hidden" name="ID_Product" value="<%=request.getParameter("ID_Product")%>">
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
