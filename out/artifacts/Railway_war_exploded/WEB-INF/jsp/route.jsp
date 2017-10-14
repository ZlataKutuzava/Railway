<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Route</title>
</head>
<body>
<h1>Routes</h1>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Rotes</h2></caption>
        <tr>
            <th>ID_Route</th>
            <th>ID_Train</th>
            <th>ID_Station</th>
            <th>Arrival Time</th>
            <th>Departure Time</th>
        </tr>
        <c:forEach var="route" items="${routeList}">
            <tr>
                <td><c:out value="${route.routeId}" /></td>
                <td><c:out value="${route.trainId}" /></td>
                <td><c:out value="${route.stationId}" /></td>
                <td><c:out value="${route.timeArrival}" /></td>
                <td><c:out value="${route.timeDeparture}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${route.routeId}' />">Edit</a>
                </td>
                <td>
                    <a href="/delete?id=<c:out value='${route.routeId}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
