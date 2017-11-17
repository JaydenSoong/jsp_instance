<%@ page import="com.jayden.beans.User" %><%--
  Created by IntelliJ IDEA.
  User: Jayden
  Date: 2017/11/17
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session = request.getSession();
    String msg;
    String title;
    Object obj = session.getAttribute("user");
    if (obj != null) {
        User user = (User) obj;
        msg = user.getName() + " 欢迎回来";
        title = "登录成功";
    } else {
        msg = "对不起，您还没有登录，请<a href=\"/login/login.jsp\">登录</a>访问";
        title = "请登录";
    }
%>
<html>
<head>
    <title><%= title %></title>
</head>
<body>
<%= msg %>
</body>
</html>
