<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medical Form</title>
</head>
<body>
<h1>Medical Form</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>BirthDay</th>
        <th>Gender</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Health Issues</th>
        <th>Action</th>
    </tr>
    <c:forEach var="medical" items="${medicalForm}">
        <tr>
            <td>${medical.id}</td>
            <td>${medical.fullName}</td>
            <td>${medical.dateOfBirth}</td>
            <td>${medical.gender}</td>
            <td>${medical.address}</td>
            <td>${medical.phoneNumber}</td>
            <td>${medical.healthIssues}</td>
            <td>
                <a href="/medical/medical-update/${medical.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/">Quay lại trang chủ</a>
</body>
</html>
