

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
       
    </head>
    <body>
        <div id="header">
            <div class="inHeader">
                <div class="mosAdmin">
                    Xin chào !<br>
                    <a href="/PRJ301/default.jsp">Trang người dùng</a> |  <a href="#"><%=session.getAttribute("username") %></a>
                </div>
                <div class="clear"></div>
            </div>
        </div>

    </body>
</html>
