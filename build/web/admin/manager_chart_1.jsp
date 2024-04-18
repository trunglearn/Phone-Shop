<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
        <title>Thống kê</title>

        <!-- load Google AJAX API -->
        <script type="text/javascript" src="http://www.google.com/jsapi"></script>
        <script type="text/javascript">
            // Load the Visualization API and the piechart package.
            google.load('visualization', '1', {'packages': ['columnchart']});

            // Set a callback to run when the Google Visualization API is loaded.
            google.setOnLoadCallback(drawChart);

            // Callback that creates and populates a data table,
            // instantiates the pie chart, passes in the data and
            // draws it.
            function drawChart() {

                // Create the data table.    
                var data = google.visualization.arrayToDataTable([
                    ['Country', 'Area(square km)'],
            <c:forEach var="item" items="${lisItem}">['${item.name}',${item.value}],</c:forEach>


                ]);
                // Set chart options
                var options = {
                    'title': 'Thống kê sản phẩm bán chạy',
                    is3D: true,
                    pieSliceText: 'label',
                    tooltip: {showColorCode: true},
                    'width': 700,
                    'height': 300
                };

                // Instantiate and draw our chart, passing in some options.
                var chart = new google.visualization.PieChart(document.getElementById('Chart2'));
                chart.draw(data, options);
            }
            </script>
            <script type="text/javascript" src="http://www.google.com/jsapi"></script>
            <script type="text/javascript">
            //load the Google Visualization API and the chart
            google.load('visualization', '1', {'packages': ['columnchart']});

            //set callback
            google.setOnLoadCallback(createChart);

            //callback function
            function createChart() {

                //create data table object
                var dataTable = new google.visualization.DataTable();

                //define columns
                dataTable.addColumn('string', 'Quarters 2009');
                dataTable.addColumn('number', 'Số lượng(chiếc)');

                //define rows of data
                dataTable.addRows([<c:forEach var="item" items="${lisItem}">['${item.name}',${item.value}],</c:forEach>]);

                //instantiate our chart object
                var chart = new google.visualization.ColumnChart(document.getElementById('chart'));

                //define options for visualization
                var options = {width: 700, height: 300, is3D: true, title: 'Thống kê sản phẩm được bán của cửa hàng'};

                //draw our chart
                chart.draw(dataTable, options);

            }
            </script>

        </head>
    </head>
    <body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
            <div id="rightContent">
                <div id="Chart2"></div>
            </div>
          
            <div class="clear"></div>

        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
