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
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<form action="/users/register" method="post">
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" required/><br/>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required/><br/>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required/><br/>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address"/><br/>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone"/><br/>

    <label for="status">Status:</label>
    <input type="checkbox" id="status" name="status" value="true"/><br/>

    <input type="submit" value="Register"/>
</form>

<a href="/users/login">Back to Login</a>
</body>
</html>
