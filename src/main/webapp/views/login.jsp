<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/23/2024
  Time: 2:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h1>Login Page</h1>
<form action="login" method="post">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>

    <button type="submit">Login</button>
</form>

<p style="color:red;">
    <%-- Hiển thị thông báo lỗi nếu có --%>
    <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
</p>
</body>
</html>
