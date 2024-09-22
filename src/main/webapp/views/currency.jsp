<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/23/2024
  Time: 4:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<h1>Chuyển đổi từ USD sang VNĐ</h1>
<form action="/convert" method="POST">
    <label for="usd">USD:</label>
    <input type="text" id="usd" name="usd">
    <label for="rate">Rate:</label>
    <input type="text" id="rate" name="rate">
    <button type="submit">Convert</button>
</form>
</body>
</html>

