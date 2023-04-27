<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/27/2023
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency converter app</title>
</head>
<body>
<form action="/result">
    <label for="id">Nhập số tiền bạn muốn chuyển đổi</label>
    <input type="number" name="number" id="id">
    <button type="submit">Kết quả</button>
</form>
<p>Kết quả = ${result}</p>
</body>
</html>
