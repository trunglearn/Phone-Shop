<%@page import="dao.ProductDAOImpl"%>
<%@page import="model.DetailsOfInvoiceItems"%>
<%@page import="dao.DetailsOfInvoiceItemsDAOImpl"%>
<%@ page import="java.math.BigDecimal" %>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String exportToExcel = request.getParameter("exportToExcel");
    if (exportToExcel != null && exportToExcel.equalsIgnoreCase("YES")) {
        // Set headers to download file as Excel
        response.setContentType("application/vnd.ms-excel; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=bill.xls");

        // Retrieve data to populate the bill
        ProductDAOImpl productDAO = new ProductDAOImpl();
        int ID_Invoice = 0;
        try {
            ID_Invoice = Integer.parseInt(request.getParameter("ID_Invoice"));
        } catch (NumberFormatException e) {
            out.println("Invalid Invoice ID");
            return;
        }
        DetailsOfInvoiceItemsDAOImpl detailsOfInvoiceItemsDAO = new DetailsOfInvoiceItemsDAOImpl();

        // Output the bill data for Excel
        out.println("Mã Chi Tiết\tTên Sản Phẩm\tSố Lượng\tĐơn Giá\tGiảm Giá\tThành Tiền");
        for (DetailsOfInvoiceItems detail : detailsOfInvoiceItemsDAO.getListDetailsOfInvoiceItemsByIDInvoice(ID_Invoice)) {
            out.println(detail.getID_Details_of_invoice_items() + "\t" +
                        productDAO.getInforProduct(detail.getID_Product()).getName_Product() + "\t" +
                        detail.getQuantity() + "\t" +
                        detail.getUnit_price() + "\t" +
                        detail.getDiscount() + "\t" +
                        detail.getTotal_amount());
        }
    } else {
        // HTML output begins here
%>
<!DOCTYPE html>
<html>
    <head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <style>
        body, h3, table {
            font-family: "Times New Roman", Times, serif;
        }
    </style>
    <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <h3>Quản lý loại tin tức</h3>
                <table class="data">
                    <tr class="data">
                        <th class="data">Mã chi tiết</th>
                        <th class="data">Mã sản phẩm</th>
                        <th class="data">Số lượng</th>
                        <th class="data">Đơn giá</th>
                        <th class="data">Giảm giá</th>      
                        <th class="data">Thành tiền</th>
                    </tr>
                <% ProductDAOImpl sanPhamDAO = new ProductDAOImpl();
                    int ID_Invoice = Integer.parseInt(request.getParameter("ID_Invoice"));
                    DetailsOfInvoiceItemsDAOImpl detailsOfInvoiceItemsDAOImpl = new DetailsOfInvoiceItemsDAOImpl();
                    for (DetailsOfInvoiceItems cthd : detailsOfInvoiceItemsDAOImpl.getListDetailsOfInvoiceItemsByIDInvoice(ID_Invoice)) {
                %>
                <tr class="data">
                    <td class="data"><%=cthd.getID_Details_of_invoice_items()%></td>

                    <td class="data"><%=sanPhamDAO.getInforProduct(cthd.getID_Product()).getName_Product()%></td>
                    <td class="data"><%=cthd.getQuantity()%></td>

                    <td class="data"><%= new BigDecimal(cthd.getUnit_price()).intValue()%></td>
                    <td class="data"><%=cthd.getDiscount()%></td>
                    <td class="data"><%= new BigDecimal(cthd.getTotal_amount()).intValue()%></td>

                </tr>
                <% }%>

            </table>
            <!-- Export to Excel link -->
            <a href="detail_bill.jsp?ID_Invoice=<%=request.getParameter("ID_Invoice") %>&exportToExcel=YES">Export to Excel</a>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
<%
    }
%>
