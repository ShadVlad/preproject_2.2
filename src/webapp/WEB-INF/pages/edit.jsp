<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 06.04.2020
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<form action="${action}" method="POST">
    <label for="firstName">First name:</label>
    <input type="text" name="firstName" id="firstName" value=${user.firstName}>
    <label for="lastName">Last name:</label>
    <input type="text" name="lastName" id="lastName" value=${user.lastName}>
    <label for="email">Email:</label>
    <input type="text" name="email" id="email" value=${user.email}>
    <input type="hidden" name="id" value="${user.id}">
    <input type="submit" value="edit">
</form>

</body>
</html>
