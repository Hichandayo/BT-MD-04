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
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="save-calculator" method="get">
    <label for="num1">Number 1:</label>
    <input type="number" name="num1" id="num1" step="any" required><br/>

    <label for="num2">Number 2:</label>
    <input type="number" name="num2" id="num2" step="any" required><br/>

    <label>Operation:</label><br/>
    <input type="radio" name="operator" value="add" required> Add (+)<br/>
    <input type="radio" name="operator" value="subtract"> Subtract (-)<br/>
    <input type="radio" name="operator" value="multiply"> Multiply (*)<br/>
    <input type="radio" name="operator" value="divide"> Divide (/)<br/>

    <button type="submit">Calculate</button>
</form>

</body>
</html>