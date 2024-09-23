<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="/users/login" method="post">
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required/>
    <br/>
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required/>
    <br/>
    <input type="submit" value="Login"/>
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>
<a href="/users/register">Register</a>
</body>
</html>
