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
    <title>Upload Song</title>
</head>
<body>
<h1>Upload bài hát</h1>

<!-- Form upload -->
<form:form action="/songs/upload" method="post" enctype="multipart/form-data" modelAttribute="uploadModel">
    <form:label path="name">Name:</form:label>
    <form:input path="name" id="name" required="true"/><br>

    <form:label path="singer">Singer:</form:label>
    <form:input path="singer" id="singer" required="true"/><br>

    <form:label path="genre">Genre:</form:label>
    <form:input path="genre" id="genre" required="true"/><br>

    <form:label path="single">Upload Song:</form:label>
    <input type="file" name="single" id="single" accept="audio/*" required="true"/><br>

    <button type="submit">Upload</button>
</form:form>
</body>
</html>