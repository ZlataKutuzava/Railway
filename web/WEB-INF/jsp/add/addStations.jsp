<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexb
  Date: 14-Oct-17
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Stations</title>
</head>
<body>

<c:choose>
    <c:when test="${station != null}">
        <h1>Editing Station</h1>
    </c:when>
    <c:otherwise>
        <h1>Adding Station</h1>
    </c:otherwise>
</c:choose>
<form>
    <table>
        <tr>
            <c:if test="${station!=null}"><th>ID Station</th></c:if>
            <th>Station Name</th>
        </tr>
        <tr>
            <c:if test="${station != null}">
                <td>
                    <span><c:out value='${station.stationId}'/></span>
                </td>
            </c:if>
            <td>

                <input type="text" name="stationName"
                       value="<c:out value='${station.stationName}' />"/>
            </td>
            <td colspan="2" align="center">
                <input type="submit" value="Save" formmethod="post"/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
