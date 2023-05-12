<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2023
  Time: 2:33 PM
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
    <title>Mail</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<fieldset>
    <h1 style="text-align: center">Email</h1>
    <table class="table">
        <tr>
            <td><strong>Languages:</strong> ${mail.getLanguages()}</td>
        </tr>
        <tr>
            <td><strong>Page Size:</strong> ${mail.getPageSize()}</td>
        </tr>
        <tr>
            <td><strong>Spams fillter:</strong> ${mail.getSpamsFillter()}</td>
        </tr>
        <tr>
            <td><strong>Signature:</strong> ${mail.getSignature()}</td>
        </tr>
        <tr>
            <td><a class="btn btn-primary" href="/mail/updateMail"
                   role="button">Update</a></td>
        </tr>
    </table>
</fieldset>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
