<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title></title>
</head>
<body>
<h1>BT01</h1>
<a href="CustomerServlet?action=getCustomer">
    Hien thi danh sach
</a>
<div >
    <h1 >Danh sách khách hàng</h1>
    <table >
        <thead>
        <tr >
            <th >Tên</th>
            <th >Ngày sinh</th>
            <th >Địa chỉ</th>
            <th >Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="cus">
            <tr >
                <td >${cus.name}</td>
                <td >${cus.birthDay}</td>
                <td >${cus.address}</td>
                <td >
                    <img alt="${cus.name}" src="${cus.imageUrl}" style="max-width: 100px; max-height: 100px;" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<h1>BT02</h1>
<h1>Máy Tính Cơ Bản</h1>
<form action="CalculatorServlet" method="post">
    <table>
        <tr>
            <label for="input1">Toán Hạng 1:</label>
            <td><input type="text" name="operand1" id="input1"/></td>
        </tr>
        <tr>
            <label for="input2">Toán Hạng 2:</label>
            <td><input type="text" name="operand2" id="input2" /></td>
        </tr>
        <tr>
            <td>Toán Tử:</td>
            <td>
                <label>
                    <select name="operator">
                        <option value="+">Cộng</option>
                        <option value="-">Trừ</option>
                        <option value="*">Nhân</option>
                        <option value="/">Chia</option>
                    </select>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Tính Toán" /></td>
        </tr>
    </table>
</form>
</body>
</html>
