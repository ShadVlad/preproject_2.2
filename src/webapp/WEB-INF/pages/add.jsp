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
<form:form action="${action}" method="POST" modelAttribute="adduser">
    <label for="username">User name:</label><br>
    <input type="text" name="username" id="username" value=${user.userName}><br><br>
    <label for="password">Password:</label><br>
    <input type="text" name="password" id="password" value=${user.password}><br><br>

    <table>
        <tr>
            <td>Roles:</td>
            <td><form:checkboxes path="roles" items="${rolesList}"/>
            </td>
        </tr>
    </table>


<%--        <input type="hidden" name="checkboxRole" value="1"/><br>
        <label for="role1">admin</label><br>
        <input type="checkbox" name="checkboxRole" id="role1" value="admin"><br>
        <label for="role2">user</label><br>
        <input type="checkbox" name="checkboxRole" id="role2" value="user"><br>--%>

    <input type="submit" value="Add user">

</form:form>

</body>
</html>
