<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 09.04.2020
  Time: 7:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="form">
    <h3>Вход в систему</h3><br>
    <form method="post" action="/login">
        <label >Login    </label><br>
        <input type="text" required placeholder="login" name="j_username"><br><br>
        <label >Password </label><br>
        <input type="password" required placeholder="password" name="j_password"><br><br>
        <input class="button" type="submit" value="Войти">
    </form>
</div>

</body>
</html>
