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
            <tr><th>Name</th><th>Surname</th><th>e-mail</th><th colspan="2">Action</th></tr>
        </c:when>
        <c:when test = "${param.locale.equals('ru')}">
            <caption>ВСЕ ПОЛЬЗОВАТЕЛИ</caption>
            <tr><th>Имя</th><th>Фамилия</th><th>e-mail</th><th colspan="2">Действие</th></tr>
        </c:when>
        <c:otherwise>
            <caption>All users</caption>
            <tr><th>Name</th><th>Surname</th><th>e-mail</th><th colspan="2">Action</th></tr>
        </c:otherwise>
    </c:choose>
    <c:forEach var="user" items="${requestScope.users}">
        <tr><td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td align="center"><c:out value="${user.email}"/>
            <td align="center">
                <a href="/edit/${user.id}">изменить</a>
            </td>
            <td align="center">
                <a href="/delete/${user.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr />
<c:choose>
    <c:when test = "${param.locale.equals('en')}">
        <a href="/add"/>">Add user</a>
    </c:when>
    <c:when test = "${param.locale.equals('ru')}">
        <a href="/add"/>"Добавить пользователя</a>
    </c:when>
    <c:otherwise>
        <a href="/add"/>"Add user</a>
    </c:otherwise>
</c:choose>

<hr /></body>
</html>
