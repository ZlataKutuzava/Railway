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

<h1>Adding Route</h1>
<form>
    <table>
        <tr>
            <th>ID Route</th>
    <input type="text" name="id_route"
           value="<c:out value='${route.id_route}' />"  />
        </tr>
        <tr>
            <th>ID Train</th>
            <input type="text" name="id_train"
                   value="<c:out value='${route.id_train}' />"/>
        </tr>
        <tr>
            <th>ID Station</th>
            <input type="text" name="id_station"
                   value="<c:out value='${route.id_station}' />"  />
        </tr>
        <tr>
            <th>Arrival Time</th>
            <input type="text" name="t_arr"
                   value="<c:out value='${route.t_arr}' />"/>
        </tr>
        <tr>
            <th>Departure Time</th>
            <input type="text" name="t_der"
                   value="<c:out value='${route.t_der}' />"/>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" />
            </td>
        </tr>
    />
    </table>
</form>

<h1>Adding Stations</h1>
<form>
    <table>
        <tr>
            <th>ID Station</th>
            <input type="text" name="id_route"
                   value="<c:out value='${station.id_station}' />"  />
        </tr>
        <tr>
            <th>Station Name</th>
            <input type="text" name="station_name"
                   value="<c:out value='${station.station_name}' />"/>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" />
            </td>
        </tr>
        />
    </table>
</form>

<h1>Adding Trains</h1>
<form>
    <table>
        <tr>
            <th>ID Train</th>
            <input type="text" name="id_route"
                   value="<c:out value='${trains.id_train}' />"  />
        </tr>
        <tr>
            <th>Train number</th>
            <input type="text" name="station_name"
                   value="<c:out value='${trains.train_number}' />"/>
        </tr>
        <tr>
            <th>type</th>
            <input type="text" name="station_name"
                   value="<c:out value='${trains.type}' />"/>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Save" />
            </td>
        </tr>
        />
    </table>
</form>


</body>
</html>
