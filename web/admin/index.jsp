<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <c:set var="root" value="${pageContext.request.contextPath}"/>
        <link href="/PRJ301/css/mos-style.css" rel='stylesheet' type='text/css' />
</head
<body>
    <jsp:include page="header.jsp"></jsp:include>
        <div id="wrapper">
        <jsp:include page="left.jsp"></jsp:include>
        
   
       
        <div class="clear"></div>
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
</body>
</html>
