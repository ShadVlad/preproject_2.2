<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vladimir
  Date: 04.04.2020
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
    <table border="1" width="50%">
        <c:choose>
        <c:when test = "${param.locale.equals('en')}">
            <caption>CARS</caption>
        </c:when>
        <c:when test = "${param.locale.equals('ru')}">
            <caption>МАШИНЫ</caption>
        </c:when>
        <c:otherwise>
            <caption>CARS</caption>
        </c:otherwise>
        </c:choose>
        <tr>
            <th>Brand</th><th>Model</th><th>Series</th>
        </tr>
        <c:forEach var="car" items="${cars}">
            <tr>
                <td align="left">${car.brand}</td>
                <td align="center">${car.model}</td>
                <td align="center">${car.series}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
