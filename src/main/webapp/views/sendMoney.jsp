<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/12/2024
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/AccountServlet" method="post">
    Tai khoản ngươi nhạn
    <input type="number" name="idReceiver" />
    so tien
    <input type="number" name="amount" />
    <input type="submit" value="SEND" name="action">
</form>
<c:if test="${error!=null}">
    <p class="text-success">${error}</p>
</c:if>
</body>
</html>
