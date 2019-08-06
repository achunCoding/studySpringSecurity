<%--
  Created by IntelliJ IDEA.
  User: 大春
  Date: 2019/8/4
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录页面</h1>
<form action="${pageContext.request.contextPath}/userLogin" method="post" default-target-ur>
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password">
    <input type="submit" value="login">
</form>

</body>
</html>
