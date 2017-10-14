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
    <table border="1" cellpadding="5">
        <caption><h2>List of Stations</h2></caption>
        <tr>
            <th>ID_Station</th>
            <th>Station Name</th>
        </tr>
        <c:forEach var="stations" items="${StationsDispaly}">
            <tr>
                <td><c:out value="${station.id_station}" /></td>
                <td><c:out value="${station.station_name}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${station.id_station}' />">Edit</a>
                </td>
                <td>
                    <a href="/delete?id=<c:out value='${station.id_station}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
