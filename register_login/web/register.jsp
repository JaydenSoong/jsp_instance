<%-- Date: 2017/11/26, Time: 22:26 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        h3{color:#f00;}
    </style>
</head>
<body>
    <%
       String msg = "";
        Object obj = request.getAttribute("userExist");
        if (obj != null){
            msg = obj.toString();
        }
    %>
    <h2>用户注册</h2>
    <form action="<c:url value="/RegisterServlet" />" method="post">
        <label>
            <span>用户名：</span>
            <input type="text" name="username">
        </label>
        <br>
        <label>
            <span>密&nbsp;&nbsp;&nbsp;码：</span>
            <input type="password" name="password">
        </label>
        <br>
        <input type="submit" value="注册">
    </form>
    <h3><%=msg%></h3>
</body>
</html>
