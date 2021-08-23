<%@ page import="by.training.Task08XML_WebParsing.entity.Periodical" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- All credit to https://www.geeksforgeeks.org/getattribute-passing-data-from-server-to-jsp !-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap-4.3.1-dist/css/bootstrap.css">
    <title>Result table</title>
</head>
<body>
<table class="table table-striped">
    <caption>Your parsed XML</caption>
    <thead class="thead-dark">
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Type</th>
        <th scope="col">Periodicity</th>
        <th scope="col">Is colourful</th>
        <th scope="col">Capacity</th>
        <th scope="col">Cover</th>
    </tr>
    </thead>
    <tbody>
    <%List<Periodical> periodicals = (ArrayList<Periodical>)request.getAttribute("data");
    for (Periodical periodical : periodicals) {%>
    <tr>
        <th scope="row"><%=periodical.getTitle()%></th>
        <td><%=periodical.getPaperType()%></td>
        <td><%=periodical.getPeriodicity()%></td>
        <td><%=periodical.getCharacteristic().isColourful()%></td>
        <td><%=periodical.getCharacteristic().getCapacity()%></td>
        <td><%=periodical.getCharacteristic().getCover()%></td>
    </tr>
    <%}%>
    </tbody>
</table>
<script src="assets/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
</body>
</html>