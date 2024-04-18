<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Account"%>
<%@page import="model.TypesOfNews"%>
<%@page import="dao.NewsDAO"%>
<%@page import="model.Category"%>
<%@page import="model.Value"%>
<%@page import="dao.CategoryDAO"%>
<%@ page import="java.util.List" %>


<%@page import="dao.CategoryDAOImpl"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="${root}/css/mos-style.css" rel='stylesheet' type='text/css' />
        <title>Thống kê</title>

        <!-- load Google AJAX API -->
        <script type="text/javascript" src="https://www.google.com/jsapi"></script>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

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

        <script type="text/javascript">
            google.charts.load('current', {'packages': ['bar']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Tên sản phẩm');

                // Add a column for each category id, startDate, endDate, etc. if needed
                data.addColumn('number', 'Số lượng bán');

                // Assuming item.getValue() returns a numeric value and is used for quantity
            <% List<Value> listItems = (List<Value>) request.getAttribute("lisItem1");
            if(listItems != null) {
                for (Value item : listItems) { %>
                data.addRow(['<%= item.getName() %>', <%= item.getValue() %>]);
            <%     }
            }
            %>

                var options = {
                    chart: {
                        title: 'Thống kê sản phẩm',
                        subtitle: 'Số lượng bán theo sản phẩm',
                    },
                    bars: 'vertical', // Change to 'horizontal' if preferred
                    vAxis: {title: 'Số lượng bán'},
                    hAxis: {title: 'Tên sản phẩm'},
                    width: 900,
                    height: 500
                };

                var chart = new google.charts.Bar(document.getElementById('barChart'));
                chart.draw(data, google.charts.Bar.convertOptions(options));
            }
        </script>


        <style>
            .search{
                display: flex; /* Use flexbox to lay out children inline */
                align-items: center; /* Center-align the items vertically */
                justify-content: flex-start; /* Align the items to the end of the container */
                gap: 10px; /* Add some space between the form elements */

            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
                padding: 10px;
                width: 300px; /* Adjust width as necessary */
            }

            .dropdown .dropbtn {
                background-color: #3498DB;
                color: white;
                padding: 16px;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }

            .dropdown .dropbtn:after {
                content: '▼';
                padding-left: 10px;
            }

            .show {
                display: block;
            }

        </style>
        <script>
            // Function to show or hide the dropdown content
            function toggleDropdown() {
                document.getElementById("myDropdown").classList.toggle("show");
            }

            // Function to filter dropdown content based on search input
            function filterFunction(event) {
                // Stop the event from closing the dropdown
                event.stopPropagation();

                var input, filter, div, checkboxes, i, txtValue;
                input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                div = document.getElementById("myDropdown");
                checkboxes = div.querySelectorAll('.checkbox label');
                for (i = 0; i < checkboxes.length; i++) {
                    txtValue = checkboxes[i].textContent || checkboxes[i].innerText;
                    if (txtValue.toUpperCase().indexOf(filter) > -1) {
                        checkboxes[i].style.display = "";
                    } else {
                        checkboxes[i].style.display = "none";
                    }
                }
            }

            // Function to update selected items and display them
            function updateSelectedItems(checkbox) {
                var checkboxes = document.querySelectorAll('#myDropdown input[type="checkbox"]');
                var checkedValues = Array.from(checkboxes).filter(chk => chk.checked).map(chk => chk.value);

                // You will need to handle displaying the selected items here
                // This code will need to be modified based on how you want to display them
                console.log(checkedValues.join(", "));
            }

            // Event listener for the dropdown content to prevent it from closing on internal clicks
            document.getElementById("myDropdown").addEventListener('click', function (event) {
                event.stopPropagation();
            }, false);

            // Close the dropdown if the user clicks outside of it
            window.onclick = function (event) {
                if (!event.target.matches('.dropbtn')) {
                    var dropdowns = document.getElementsByClassName("dropdown-content");
                    for (var i = 0; i < dropdowns.length; i++) {
                        var openDropdown = dropdowns[i];
                        if (openDropdown.classList.contains('show')) {
                            openDropdown.classList.remove('show');
                        }
                    }
                }
            }
        </script>
    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="wrapper">
            <jsp:include page="left.jsp"></jsp:include>
                <div id="rightContent">
                    <h2>Biểu đồ thống kê</h2>
                    <form action="ThongKeServlet" method="post">
                        Tên sản phẩm: <input type="text" name="searchTerm" />
                        Danh mục: <div class="dropdown">
                            <button style="margin-top: 30px" type="button" onclick="toggleDropdown()" class="dropbtn">Chọn loại</button>
                            <div id="myDropdown" class="dropdown-content">
                                <!--                                            <input type="text" placeholder="Search.." id="myInput" onkeyup="filterFunction()">-->
                            <% CategoryDAO categoryDAO = new CategoryDAOImpl(); %>
                            <% for (Category category : categoryDAO.getListCategory()) { %>
                            <div class="checkbox">
                                <input type="checkbox" id="category<%= category.getID_Category() %>" name="category" value="<%= category.getID_Category() %>" onclick="event.stopPropagation();" onchange="updateSelectedItems(this)">
                                <label for="category<%= category.getID_Category() %>"><%= category.getName_Category() %></label>
                            </div>
                            <% } %>
                        </div>
                    </div>
                    Từ ngày: <input type="date" name="startDate" />
                    Đến ngày: <input type="date" name="endDate" />
                    <input type="submit" value="Tìm kiếm" />
                </form>
                <div id="barChart" style="width: 900px; height: 500px;"></div>



                <div id="pieChart"></div>

                <div id="columnChart"></div>
            </div>
            <div class="clear"></div>
            <jsp:include page="footer.jsp"></jsp:include>
        </div>
    </body>
</html>
