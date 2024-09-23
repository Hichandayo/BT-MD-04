<%--
  Created by IntelliJ IDEA.
  User: MBK670
  Date: 9/24/2024
  Time: 6:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gia vị bạn lựa chọn là: </title>
</head>
<body>
<h2>Gia vị bạn lựa chọn là :</h2>
<form action="save" method="post">
    <input type="checkbox" name="condiment" value="Muối"> Muối<br>
    <input type="checkbox" name="condiment" value="Tiêu"> Tiêu<br>
    <input type="checkbox" name="condiment" value="Đường"> Đường<br>
    <input type="checkbox" name="condiment" value="Bột chính"> Bột chính<br>
    <input type="submit" value="Submit">
</form>
</body>
</html>