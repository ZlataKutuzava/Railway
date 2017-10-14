<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Route</title>
</head>
<body>

<div align="center">
    <a href="/stations">Stations</a>
    <a href="/trains">Trains</a>
    <table border="1" cellpadding="5">
        <caption><h2>List of Routes</h2></caption>
        <tr>
            <th>ID_Route</th>
            <th>ID_Train</th>
            <th>ID_Station</th>
            <th>Arrival Time</th>
            <th>Departure Time</th>
        </tr>
        <c:forEach items="${routes}" var="route">
            <tr>
                <td>${route.routeId}</td>
                <td>${route.trainId}</td>
                <td>${route.stationId}</td>
                <td>${route.timeArrival}</td>
                <td>${route.timeDeparture}</td>
                <td>
                    <a href="/routes/edit/${route.routeId}">Edit</a>
                </td>
                <td>
                    <a href="/routes/delete/${route.routeId}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a style="text-decoration: none; color: green;" href="routes/add" ><h1><b>+</b></h1></a>
</div>

</body>
</html>
