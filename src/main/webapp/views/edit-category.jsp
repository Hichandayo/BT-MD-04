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
    <title>Edit Category</title>
</head>
<body>
<h1>Edit Category</h1>
<form action="/categories/edit" method="post">
    <input type="hidden" name="id" value="${category.id}"/>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${category.name}" required/>
    <br/>
    <label for="status">Status:</label>
    <input type="checkbox" id="status" name="status" ${category.status ? 'checked' : ''}/>
    <br/>
    <button type="submit">Update</button>
</form>
<a href="/categories/list-category">Back to List</a>
</body>
</html>