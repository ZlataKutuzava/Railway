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
    <table border="1" cellpadding="5">
        <caption><h2>List of Trais</h2></caption>
        <tr>
            <th>ID_Train</th>
            <th>Train Number</th>
            <th>Type</th>
        </tr>
        <c:forEach var="trains" items="${TrainsDispaly}">
            <tr>
                <td><c:out value="${trains.id_train}" /></td>
                <td><c:out value="${trains.train_number}" /></td>
                <td><c:out value="${trains.type}" /></td>
                <td>
                    <a href="/edit?id=<c:out value='${trains.id_train}' />">Edit</a>
                </td>
                <td>
                    <a href="/delete?id=<c:out value='${trains.id_train}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
