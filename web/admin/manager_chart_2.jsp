<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
    <title>Thống kê</title>

    <!-- load Google AJAX API -->
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
        // Load the Visualization API and the corechart package.
        google.load('visualization', '1', {'packages': ['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.setOnLoadCallback(drawCharts);

        function drawCharts() {
            // Create the data table for the pie chart.
            var pieData = google.visualization.arrayToDataTable([
                ['Tên sản phẩm', 'Số lượng'],
                <c:forEach var="item" items="${lisItem}">
                    ['${item.name}', ${item.value}],
                </c:forEach>
            ]);

            // Set options for the pie chart
            var pieOptions = {
                'title': 'Thống kê sản phẩm bán chạy',
                'is3D': true,
                'width': 700,
                'height': 300
            };

            // Instantiate and draw the pie chart.
            var pieChart = new google.visualization.PieChart(document.getElementById('pieChart'));
            pieChart.draw(pieData, pieOptions);

            // Create the data table for the column chart.
            var columnData = new google.visualization.DataTable();
            columnData.addColumn('string', 'Tên sản phẩm');
            columnData.addColumn('number', 'Số lượng');

            <c:forEach var="item" items="${lisItem}">
                columnData.addRow(['${item.name}', ${item.value}]);
            </c:forEach>

            // Set options for the column chart
            var columnOptions = {
                'title': 'Thống kê sản phẩm được bán của cửa hàng',
                'width': 700,
                'height': 300
            };

            // Instantiate and draw the column chart.
            var columnChart = new google.visualization.ColumnChart(document.getElementById('columnChart'));
            columnChart.draw(columnData, columnOptions);
        }
    </script>
</head>
<body>
    <jsp:include page="header.jsp"></jsp:include>
    <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
        <div id="rightContent">
            <h2>Biểu đồ thống kê</h2>
            <div id="pieChart"></div>
            <div id="columnChart"></div>
        </div>
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
