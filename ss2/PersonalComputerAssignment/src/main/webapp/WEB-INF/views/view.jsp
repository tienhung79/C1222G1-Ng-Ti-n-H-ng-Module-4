<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2023
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Caculator</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/caculator" class="container">
  <div class="input-group">
    <label for="number1">Nhập số </label>
    <input type="number"
           class="form-control" name="number1" id="number1" aria-describedby="helpId" placeholder="0">
  </div>
  <div class="input-group">
    <label for="number2">Nhập số</label>
    <input type="number"
           class="form-control" name="number2" id="number2" aria-describedby="helpId" placeholder="0">
  </div>
  <button type="submit" name="caculate" value="add">Cộng</button>
  <button type="submit" name="caculate" value="apart">Trừ</button>
  <button type="submit" name="caculate" value="core">Nhân</button>
  <button type="submit" name="caculate" value="divide">Chia</button>
</form>
<p>Kết quả là: ${result}</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>