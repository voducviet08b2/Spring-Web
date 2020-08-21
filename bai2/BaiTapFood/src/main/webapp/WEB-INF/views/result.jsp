<%--
  Created by IntelliJ IDEA.
  User: viiet
  Date: 8/21/2020
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Bạn đã chọn:</h2>
<c:forEach var="con" items="${condiment}" >
    <p><c:out value="${con}"></c:out></p>
</c:forEach>
</body>
</html>
