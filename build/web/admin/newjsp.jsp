<%-- 
    Document   : newjsp
    Created on : Jan 24, 2024, 7:53:37 PM
    Author     : ACERR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
    <link href="E:/JavaWeb/PRJ301/web/css/mos-style.css" rel='stylesheet' type='text/css' />
</head>
<body>
    <h1>Hello World!</h1>
    <jsp:include page="left.jsp"></jsp:include>
</body>
</html>
