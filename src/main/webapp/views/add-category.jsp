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
    <title>Add New Category</title>
</head>
<body>
<h1>Add New Category</h1>
<form action="/categories/add" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required/>
    <br/>
    <label for="status">Status:</label>
    <!-- Default value is false; if checked, true will be sent -->
    <input type="checkbox" id="status" name="status" value="true"/>
    <br/>
    <button type="submit">Add</button>
</form>

<a href="/categories">Back to List</a>
</body>
</html>

