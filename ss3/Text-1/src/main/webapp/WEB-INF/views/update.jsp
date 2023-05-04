<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2023
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form action="/mail/update" method="post" modelAttribute="mail">
<fieldset>
    <h1 style="text-align: center">Update</h1>
    <table>
        <tr>
            <td><strong>Languages:</strong></td>
            <td><form:select path="languages">
                <form:options items="${languageList}"/>
            </form:select></td>
        </tr>
        <tr>
            <td><strong>Page Size:</strong></td>
            <td>Show <form:select path="pageSize">
                <form:options items="${pageSizeList}"/>
            </form:select> email per page</td>
        </tr>
        <tr>
            <td><strong>Spams fillter:</strong></td>
            <td><form:checkbox path="spamsFillter" value="Enable spams filter"/> Enable spams filter </td>
        </tr>
        <tr>
            <td><strong>Signature:</strong></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td><button type="submit">Update</button></td>
        </tr>
    </table>
</fieldset>
</form:form>
</body>
</html>
