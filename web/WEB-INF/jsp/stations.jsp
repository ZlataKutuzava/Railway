<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 14.10.2017
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stations</title>
</head>
<body>

<div align="center">
    <a href="/trains">Trains</a>
    <a href="/routes">Routes</a>
    <table border="1" cellpadding="5">
        <caption><h2>List of Stations</h2></caption>
        <tr>
            <th>ID_Station</th>
            <th>Station Name</th>
        </tr>
        <c:forEach var="station" items="${stations}">
            <tr>
                <td><c:out value="${station.stationId}" /></td>
                <td><c:out value="${station.stationName}" /></td>
                <td>
                    <a href="/stations/edit/<c:out value='${station.stationId}' />">Edit</a>
                </td>
                <td>
                    <a href="/stations/delete/<c:out value='${station.stationId}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a style="text-decoration: none; color: green;" href="/stations/add" ><h1><b>+</b></h1></a>
</div>

</body>
</html>
