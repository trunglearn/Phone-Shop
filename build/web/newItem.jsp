<%-- 
    Document   : newItem
    Created on : May 20, 2017, 10:56:49 PM
    Author     : ACERR
--%>

<%@page import="dao.TypesOfNewsDAOImpl"%>
<%@page import="model.TypesOfNews"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% TypesOfNewsDAOImpl TypesOfNewsDAO = new TypesOfNewsDAOImpl();
        %>
        <div class="col-sm-3">
            <div class="left-sidebar">
                <h2>Loại tin</h2>
                <div class="panel-group category-products" id="accordian"><!--category-productsr-->
                    <% for (TypesOfNews TypesOfNews : TypesOfNewsDAO.getListTypesOfNews()) {


                    %>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a href="typenews.jsp?ID_Types_of_news=<%=TypesOfNews.getID_Types_of_news()%>">
                                    <%=TypesOfNews.getName_Types_of_news()%>

                                </a>
                            </h4>
                        </div>

                    </div>
                    <%
                        }%>
                </div>


            </div>
    </body>
</html>
