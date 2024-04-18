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
    <jsp:include page="header.jsp"></jsp:include>

        <div id="wrapper">

        <jsp:include page="left.jsp"></jsp:include>

            <div id="rightContent">
                <h3>Thông tin sản phẩm</h3>
                <form action="/PRJ301/UpLoadProduct" method="POST" enctype="multipart/form-data">
                    <table width="95%">
                        <tr>
                            <td width="125px"><b>Tên sản phẩm</b></td>
                            <td><input type="text" class="pendek" name="Name_Product">
                            </td>
                        </tr>

                        <tr>
                            <td><b>Mã danh mục</b> </td>
                            <td>
                                <select name="ID_Category" >
                                    <option selected> Lựa chọn</option>
                                <%CategoryDAOImpl CategoryDAO = new CategoryDAOImpl();
                                    for (Category dm :CategoryDAO.getListCategory()) {
                                %>
                                <option  value="<%=dm.getID_Category()%>"><%=dm.getName_Category()%></option>
                                <% }%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hình ảnh</b></td>
                        <td>
                            <input type="file" name="image" />
                        </td>

                    </tr>

                    <tr>
                        <td width="125px"><b>Số lượng</b></td>
                        <td><input type="text" class="pendek" name="quantity">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Đơn giá</b></td>
                        <td><input type="text" class="pendek" name="unit_price">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b> Giảm giá</b></td>
                        <td><input type="text" class="pendek" name="discount">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Màn hình</b></td>
                        <td><input type="text" class="pendek" name="display">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Camera sau</b></td>
                        <td><input type="text" class="pendek" name="rear_camera">
                        </td>
                    </tr>


                    <tr>
                        <td width="125px"><b>Camera trước</b></td>
                        <td><input type="text" class="pendek" name="front_camera">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Hệ điều hành</b></td>
                        <td><input type="text" class="pendek" name="operating_system">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>cpu</b></td>
                        <td><input type="text" class="pendek" name="cpu">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Bộ nhớ</b></td>
                        <td><input type="text" class="pendek" name="memory">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Ram</b></td>
                        <td><input type="text" class="pendek" name="ram">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Kết nối</b></td>
                        <td><input type="text" class="pendek" name="connectivity">
                        </td>
                    </tr>
                    <tr>
                        <td width="125px"><b>Pin sạc</b></td>
                        <td><input type="text" class="pendek" name="battery">
                        </td>
                    </tr>

                    <tr>
                        <td width="125px"><b>Mô tả</b></td>
                        <td><input type="text" class="pendek" name="description">
                        </td>
                    </tr>
                    <tr><td></td><td>

                            <input type="submit" class="button" value="Lưu dữ liệu">


                </table>
            </form>
        </div>
        <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>

    </div>
</body>
</html>
