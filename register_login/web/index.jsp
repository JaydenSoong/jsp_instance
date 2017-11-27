<%-- Date: 2017/11/26, Time: 22:26 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${empty sessionScope.UserSession}">请<a href="<c:url value="login.jsp"/>">登录</a></c:when>
    <c:otherwise>winner, winner, chicken dinner</c:otherwise>
</c:choose>
</body>
</html>
