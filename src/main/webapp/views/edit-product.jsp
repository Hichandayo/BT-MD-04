<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h1>Edit Product</h1>
<form action="/products/edit" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${product.name}" required/>
    <br/>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" value="${product.price}" step="any" required/>
    <br/>
    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" value="${product.stock}" required/>
    <br/>
    <label for="category">Category:</label>
    <select id="category" name="category_id">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}" ${category.id == product.category_id ? 'selected' : ''}>
                    ${category.name}
            </option>
        </c:forEach>
    </select>
    <br/>
    <label for="status">Status:</label>
    <input type="checkbox" id="status" name="status" ${product.status ? 'checked' : ''}/>
    <br/>
    <button type="submit">Update</button>
</form>
<a href="/products/list-product">Back to List</a>
</body>
</html>
