<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 06.04.2020
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table width="90%">
    <c:choose>
        <c:when test = "${param.locale.equals('en')}">
            <caption>ALL USERS</caption>
            <tr><th>ID</th><th>Username</th><th>Password</th><th>Roles</th><th colspan="2">Action</th></tr>
        </c:when>
        <c:when test = "${param.locale.equals('ru')}">
            <caption>ВСЕ ПОЛЬЗОВАТЕЛИ</caption>
            <tr><th>ID</th><th>Логин</th><th>Пароль</th><th>Роли</th><th colspan="2">Действие</th></tr>
        </c:when>
        <c:otherwise>
            <caption>All users</caption>
            <tr><th>ID</th><th>Username</th><th>Password</th><th>Roles</th><th colspan="2">Action</th></tr>
        </c:otherwise>
    </c:choose>
    <c:forEach items="${users}" var="user">
        <tr><td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.username}"/></td>
            <td align="center"><c:out value="${user.password}"/>
            <td>
                <c:forEach items="${user.authorities}" var="role">${role.authority}; </c:forEach>
            </td>
            <td align="center">
                <a href="/admin/edit/${user.id}">изменить</a>
            </td>
            <td align="center">
                <a href="/admin/delete/${user.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr />
<c:choose>
    <c:when test = "${param.locale.equals('en')}">
        <a href="/add"/>Add user</a>
    </c:when>
    <c:when test = "${param.locale.equals('ru')}">
        <a href="/add"/>Добавить пользователя</a>
    </c:when>
    <c:otherwise>
        <a href="/add"/>Add user</a>
    </c:otherwise>
</c:choose>
<a href="/logout">Log out</a>
<hr /></body>
</html>
