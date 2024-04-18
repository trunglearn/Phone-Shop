<%@page import="model.Account"%>
<%@page import="model.TypesOfNews"%>
<%@page import="dao.NewsDAO"%>
<%@page import="model.Category"%>
<%@page import="dao.CategoryDAO"%>
<%@page import="dao.CategoryDAOImpl"%>
<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home | PhoneShop</title>

    </head>

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

    <body>
        <% 
            TypesOfNewsDAOImpl typesOfNewsDAO= new TypesOfNewsDAOImpl();
          Account loggedInUser = (Account) session.getAttribute("loggedInUser");
//            CategoryDAO categoryDAO = new CategoryDAOImpl();
           
        %>
        <header id="header"><!--header-->
            <div class="header_top"><!--header_top-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="contactinfo">
                                <ul class="nav nav-pills">
                                    <li><a href="#"><i class="fa fa-phone"></i> 0948287328</a></li>
                                    <li><a href="https://mail.google.com/mail"><i class="fa fa-envelope"></i>trung12082003@gmail.com</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="social-icons pull-right">
                                <ul class="nav navbar-nav">
                                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                    <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                    <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header_top-->

            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4">
                            <div class="logo pull-left">
                                <a href="default.jsp"><img src="images/home/logo.png" alt="" /></a>
                            </div>

                        </div>
                        <div class="col-sm-8" >
                            <div class="shop-menu pull-right">
                                <ul class="nav navbar-nav">
                                    <% if (session.getAttribute("username") != null ||session.getAttribute("Username") != null) { %>
                                    <li><a href="InforServlet?command=information"><i class="fa fa-user"></i><%=session.getAttribute("username")%></a></li>
                                            <% } else { %>
                                    <li><a href="LoginServlet?command=logout"><i class="fa fa-user"></i></a></li>
                                            <% } %>

                                    <!--                                    <li><a href="checkout.jsp"><i class="fa fa-crosshairs"></i>Thanh toán</a></li>-->
                                    <!--                                    <li><a href="cart.jsp"><i class="fa fa-shopbatteryg-cart"></i>Giỏ hàng</a></li>-->
                                    <% if (session.getAttribute("username") != null) { %>
                                    <li><a href="cart.jsp"><i class="fa fa-shopbatteryg-cart"></i>Giỏ hàng</a></li>
                                        <% } %>
                                        <% if (session.getAttribute("username") != null && session.getAttribute("username").equals("2@gmail.com")) { %>
                                    <li><a href="admin/index.jsp"><i class="fa fa-shopbatteryg-cart"></i>Quay lại admin</a></li>
                                        <% } %>

                                    <% if (session.getAttribute("username") != null) { %>
                                    <li><a href="LoginServlet?command=logout"><i class="fa fa-user"></i>Đăng xuất</a></li>
                                        <% } else { %>
                                    <li><a href="account.jsp"><i class="fa fa-lock"></i>Đăng nhập</a></li>
                                        <% } %>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-middle-->

            <div class="header-bottom"><!--header-bottom-->
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <div class="mainmenu pull-left">
                                <ul class="nav navbar-nav collapse navbar-collapse">
                                    <li><a href="default.jsp" class="active">Trang chủ</a></li>


                                    </li>
                                    <li class="dropdown"><a href="news.jsp">Tin tức<i class="fa fa-angle-down"></i></a>
                                        <ul role="menu" class="sub-menu">
                                            <% 
                                                  for(TypesOfNews typesOfNews: typesOfNewsDAO.getListTypesOfNews())
                                                  {
                                            %>
                                            <li><a href="typenews.jsp?ID_Types_of_news=<%=typesOfNews.getID_Types_of_news() %>"><%=typesOfNews.getName_Types_of_news() %></a></li>
                                                <% 
                                            }%>

                                        </ul>
                                    </li> 
                                    <li><a href="contact.jsp">Liên hệ</a></li>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-7">
                            <div class="search">
                                <form method="get" action="SearchServlet" style="width: 500px">
                                    <input type="text" name="Name_Product" placeholder="Nhập tên muốn tìm">
                                    <div class="dropdown">
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


                                    <select class="sorting" name="sortPrice" style="width: 120px">
                                        <option value="asc">Giá: Tăng dần</option>
                                        <option value="desc">Giá: Giảm dần</option>
                                    </select>

                                    <input type="submit" value="Tìm kiếm" name="search">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/header-bottom-->
        </header
    </body>
</html>
