<%--
  Created by IntelliJ IDEA.
  User: Jayden
  Date: 2017/11/17
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%-- 判断 request 域中是否有值，若有，则将值取出，用来显示在页面上。 --%>
<%
    String msg = "";
    Object obj = request.getAttribute("msg");
    if (obj != null) {
        msg = (String) obj;
    }
%>

<%-- Cookie 获取上次的登录名 --%>
<%
    String cname = "";
    Cookie[] cookies = request.getCookies();
    for (Cookie c : cookies) {
        if (c.getName().equals("cname")){
            cname = c.getValue();
        }
    }
%>
<html>
  <head>
    <title>登录页面</title>
  </head>
  <body>
        <p style="color: #f00;"><%= msg %></p>
        <form action="/login/LoginServlet" method="post">
            <label>用户名：
                <input type="text" name="username" value=<%=cname%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            </label>
            <label>密码：
                <input type="password" name="password">
            </label>
            <input type="submit" value="登录">
        </form>
  </body>
</html>
