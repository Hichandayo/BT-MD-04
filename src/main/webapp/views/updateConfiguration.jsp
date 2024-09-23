<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail Configuration</title>
</head>
<body>
<h1>Update Mail Setting</h1>
<form:form action="/doAdd" method="post" modelAttribute="mail">
    <form:label path="language">Language</form:label>
    <form:select path="language">
        <form:option value="vi">Tiếng Việt</form:option>
        <form:option value="en">English</form:option>
        <form:option value="jap">Japanese</form:option>
    </form:select>
    <br/>

    <form:label path="pages">Pages</form:label>
    <form:select path="pages">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
    </form:select>
    <br/>

    <!-- Spams filter -->
    <form:label path="spams">Spams filter</form:label>
    <form:checkbox path="spams"/>
    <br/>

    <!-- Signature -->
    <form:label path="signature">Signature</form:label>
    <form:textarea path="signature" rows="5" cols="30"></form:textarea>
    <br/>

    <button type="submit">Update</button>
</form:form>
</body>
</html>
