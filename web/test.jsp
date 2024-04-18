
<%@page import="java.util.ArrayList"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.NumberFormat"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test ID_Category Parameter</title>
    </head>
    <body>
        <%
            // Get the parameter value
            String idCategoryParam = request.getParameter("ID_Category");

            // Check if the parameter is not null and not empty
            int ID_Category = 0;  // Default value or handle accordingly
            if (idCategoryParam != null && !idCategoryParam.isEmpty()) {
                ID_Category = Integer.parseInt(idCategoryParam);
            }
        %>

        <h1>Test ID_Category Parameter</h1>
        <p>ID_Category Parameter: <%= idCategoryParam %></p>
        <p>Parsed ID_Category: <%= ID_Category %></p>

    </body>
</html>

