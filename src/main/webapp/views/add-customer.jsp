<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/10/2024
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm mới khách hàng</h1>
<form action="/customers" method="post">
    <div>
        <label for="name"></label>
        <input type="text" name="name" id="name">
    </div>
    <div>
        <label for="address">address</label>
        <input type="text" name="address" id="address">
    </div>
    <div>
        <label for="email">email</label>
        <input type="email" name="email" id="email">
    </div>
    <input type="submit" name="action" value="ADD">

</form>
</body>
</html>
