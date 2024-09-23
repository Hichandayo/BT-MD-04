<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Product List</title>
</head>
<body>
<h1>Product List</h1>
<a href="/products/add">Add New Product</a>
<a href="/list2">Quay lại trang chủ</a>
<a href="users/view-cart">Kiểm tra đơn hàng</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Category</th>
        <th>Status</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="products" items="${products}">
        <tr>
            <td>${products.id}</td>
            <td>${products.name}</td>
            <td>${products.price}</td>
            <td>${products.stock}</td>
            <td>${products.category_id}</td>
            <td>${products.status ? 'Available' : 'Not Available'}</td>
            <td>
                <a href="/products/edit/${products.id}">Chỉnh sửa</a>
                <a href="/products/delete/${products.id}">Xoá</a>
                <a href="/products/add-to-cart/${products.id}">Thêm vào giỏ hàng</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>