<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/28/2023
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sandwich Condiments</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="/sandwich" class="border bounded-1" style="width:200px;text-align: center">
        <h1>Menu Spice</h1>
        <c:forEach var="spice" items="${ListSpice}">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="${spice}" name="spice">
                <label class="form-check-label">
                        ${spice}
                </label>
            </div>
        </c:forEach>
        <button type="submit" style="margin-left: 24px">Save</button>
    </form>
    <form class="border bounded-1" style="width:200px;text-align: center">
        <tr><h1> Your List Spice</h1></tr>
        <ul>
            <c:forEach var="spice" items="${spiceList}">
                <li><p>${spice}</p></li>
            </c:forEach>
        </ul>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>