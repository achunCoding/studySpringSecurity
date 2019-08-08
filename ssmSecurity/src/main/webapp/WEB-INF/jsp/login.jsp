<%--
  Created by IntelliJ IDEA.
  User: 大春
  Date: 2019/8/4
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h1>登录页面</h1>
<c:if test="${not empty  param.error}">
    <font color="red">用户名或密码错误</font>
</c:if>
<form action="${pageContext.request.contextPath}/userLogin" method="post" >
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password">
    <input type="submit" value="login">
</form>

</body>
</html>
