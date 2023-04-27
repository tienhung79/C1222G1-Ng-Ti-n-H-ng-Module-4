<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/27/2023
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result">
    <label>Nhập từ cần dịch</label>
    <input type="text" name="englishCheck">
    <button type="submit">Dịch</button>;
</form>
<p>Kết quả là: ${result}</p>
</body>
</html>
