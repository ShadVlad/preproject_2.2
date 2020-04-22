<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 06.04.2020
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="${action}" method="POST">
    <label for="username">User name:</label><br>
    <input type="text" name="userName" id="username" value=${user.username}><br><br>
    <label for="password">Password:</label><br>
    <input type="text" name="password" id="password" value=${user.password}><br><br>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>Roles:</td>--%>
<%--            <td><form:checkboxes path="checkedRoles" items="${rolesList}"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>

    <label >Roles:</label>
    <input type="hidden" name="checkedRoles" value="1"/><br>
    <input type="checkbox" name="checkedRoles" id="role1" value="admin">
    <label style="white-space: pre-wrap" for="role1">ADMIN    </label>
    <input type="checkbox" name="checkedRoles" id="role2" value="user">
    <label style="white-space: pre-wrap" for="role2">USER    </label>
    <input type="checkbox" name="checkedRoles" id="role3" value="anonym">
    <label for="role3">ANONYM</label><br>

    <input type="submit" value="Add user">

</form>

</body>
</html>
