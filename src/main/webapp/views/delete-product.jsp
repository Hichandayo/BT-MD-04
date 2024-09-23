<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Delete Category</h1>
<form action="/products/delete/${product.id}" method="post">
    <p>Are you sure you want to delete the product with ID <strong>${product.id}</strong>?</p>
    <input type="submit" value="Delete">
    <a href="/categories/list-category">Cancel</a>
</form>
</body>
</html>