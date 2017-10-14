<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Админ
  Date: 14.10.2017
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>

<body>

<c:choose>
    <c:when test="${route != null}">
        <h1>Editing Route</h1>
    </c:when>
    <c:otherwise>
        <h1>Adding Route</h1>
    </c:otherwise>
</c:choose>

<form>
    <table>
        <tr>
            <c:if test="${route!=null}"><th>ID Route</th></c:if>
            <th>ID Train</th>
            <th>ID Station</th>
            <th>Arrival Time</th>
            <th>Departure Time</th>
        </tr>
        <tr>
            <c:if test="${route != null}">
                <td>
                    <span><c:out value='${route.routeId}'/></span>
                </td>
            </c:if>

            <td>
                <input type="text" name="trainId"
                       value="<c:out value='${route.trainId}' />"/>
            </td>
            <td>

                <input type="text" name="stationId"
                       value="<c:out value='${route.stationId}' />"  />
            </td>
            <td>

                <input type="text" name="timeArrival"
                       value="<c:out value='${route.timeArrival}' />"/>
            </td>
            <td>

                <input type="text" name="timeDeparture"
                       value="<c:out value='${route.timeDeparture}' />"/>
            </td>
            <td colspan="2" align="center">
                <input type="submit" value="Save" formmethod="post"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
