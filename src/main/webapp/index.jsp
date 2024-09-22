<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/10/2024
  Time: 3:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Discount Calculator</title>
</head>
<body>
<h1>BT1</h1>
<form action="calculateDiscount" method="post">
    <label for="description">Product Description:</label>
    <input type="text" id="description" name="description" required><br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <label for="discount">Discount Percent:</label>
    <input type="number" id="discount" name="discount" step="0.01" required><br><br>

    <button type="submit">Calculate Discount</button>
</form>
<h1>BT2</h1>
<form action="showUserData" method="get">
    <button type="submit">Show User Data</button>
</form>
<h1>BT3</h1>
<a href="./login">Login</a>
</body>
</html>
