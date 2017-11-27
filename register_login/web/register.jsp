<%-- Date: 2017/11/26, Time: 22:26 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <style>
        p{color:#f00;}
        form{width: 50%; margin: 0 auto}
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
        Object obj = request.getAttribute("userExist");
        if (obj != null){
            msg = obj.toString();
        }
    %>
    <h2>用户注册</h2>

    <form action="<c:url value="/RegisterServlet" />" method="post" class="form-horizontal" >
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" name="username" class="form-control" id="inputEmail3" placeholder="Username">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="Password">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">注册</button>
            </div>
        </div>
        <p><%=msg%></p>
    </form>
</body>
</html>
