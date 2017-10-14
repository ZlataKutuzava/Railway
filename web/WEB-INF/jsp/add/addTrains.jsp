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
    <title>Train</title>
</head>
<body>

<c:choose>
    <c:when test="${train != null}">
        <h1>Editing Train</h1>
    </c:when>
    <c:otherwise>
        <h1>Adding Train</h1>
    </c:otherwise>
</c:choose>
<form>
    <table>
        <tr>
            <c:if test="${train!=null}"><th>ID Train</th></c:if>
            <th>Train number</th>
            <th>Type</th>
        </tr>
        <tr>
            <c:if test="${train != null}">
                <td>
                    <span><c:out value='${train.trainId}'/></span>
                </td>
            </c:if>
        <td>

            <input type="text" name="trainNumber"
                   value="<c:out value='${train.trainNumber}' />"/>
        </td>
        <td>

            <input type="text" name="trainType"
                   value="<c:out value='${train.trainType}' />"/>
        </td>
        <td colspan="2" align="center">
            <input type="submit" value="Save" formmethod="post"/>
        </td>
        </tr>
    </table>
</form>

</body>
</html>
