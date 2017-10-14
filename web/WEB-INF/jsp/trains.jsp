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
    <title>Trains</title>
</head>
<body>

<div align="center">
    <a href="/stations">Stations</a>
    <a href="/routes">Routes</a>
    <table border="1" cellpadding="5">
        <caption><h2>List of Trains</h2></caption>
        <tr>
            <th>ID_Train</th>
            <th>Train Number</th>
            <th>Type</th>
        </tr>
        <c:forEach var="train" items="${trains}">
            <tr>
                <td><c:out value="${train.trainId}" /></td>
                <td><c:out value="${train.trainNumber}" /></td>
                <td><c:out value="${train.trainType}" /></td>
                <td>
                    <a href="<c:url value="/trains/edit/${train.trainId}" />">Edit</a>
                </td>
                <td>
                    <a href="<c:url value="/trains/delete/${train.trainId}"/>">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a style="text-decoration: none; color: green;" href="/trains/add" ><h1><b>+</b></h1></a>
</div>

</body>
</html>
