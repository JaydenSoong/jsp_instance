<%-- Date: 2017/11/26, Time: 22:26 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户登录</title>
    <style>
        p{color:#f00;}
        form{width: 40%; margin: 0 auto}
        h2{text-align: center;}
    </style>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="<c:url value="bootstrap/css/bootstrap.min.css" />" >

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="<c:url value="bootstrap/js/bootstrap.min.js" />" ></script>
</head>
<body>
<%
    String msg = "";
    Object obj = request.getAttribute("wrong");
    if (obj != null){
        msg = obj.toString();
    }
%>
<h2>用户登录</h2>

<form action="<c:url value="/LoginServlet" />" method="post" class="form-horizontal" >
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"  id="basic-addon1"><span class="glyphicon glyphicon-user"></span></span>
            <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
        </div>
    </div>
    <div class="form-group">
        <div class="input-group">
            <span class="input-group-addon"  id="basic-addon2"><span class="glyphicon glyphicon-lock"></span></span>
            <input type="text" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon2">
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10" style="margin-left:0; padding-left: 0 ">
            <button type="submit" class="btn btn-default">登录</button>
        </div>
    </div>
    <p><%=msg%></p>
</form>
</body>
</html>
