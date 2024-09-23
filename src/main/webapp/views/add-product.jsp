<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Product</title>
</head>
<body>
<h1>Add New Product</h1>
<form action="/products/add" method="post">
    <input type="hidden" name="id" value="0"/>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required/>
    <br/>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="any" required/>
    <br/>
    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" required/>
    <br/>
    <label for="category">Category:</label>
    <select id="category" name="category_id"> <!-- Thay đổi từ "category" thành "category_id" -->
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <br/>
    <label for="status">Status:</label>
    <input type="checkbox" id="status" name="status"/>
    <br/>
    <input type="submit" value="ADD">
</form>
<a href="/products/list-product">Back to List</a>
</body>
</html>

