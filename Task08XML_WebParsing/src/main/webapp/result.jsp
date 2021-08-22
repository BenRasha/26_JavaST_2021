<%@ page import="by.training.Task08XML_WebParsing.entity.Periodical" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap-4.3.1-dist/css/bootstrap.css">
    <title>Result table</title>
</head>
<body>
<%List<Periodical> periodicals = (ArrayList<Periodical>)request.getAttribute("data");%>
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
    <tr>
        <th scope="row"><%=periodicals.get(0).getTitle()%></th>
        <td><%=periodicals.get(0).getPaperType()%></td>
        <td><%=periodicals.get(0).getPeriodicity()%></td>
        <td><%=periodicals.get(0).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(0).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(0).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(1).getTitle()%></th>
        <td><%=periodicals.get(1).getPaperType()%></td>
        <td><%=periodicals.get(1).getPeriodicity()%></td>
        <td><%=periodicals.get(1).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(1).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(1).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(2).getTitle()%></th>
        <td><%=periodicals.get(2).getPaperType()%></td>
        <td><%=periodicals.get(2).getPeriodicity()%></td>
        <td><%=periodicals.get(2).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(2).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(2).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(3).getTitle()%></th>
        <td><%=periodicals.get(3).getPaperType()%></td>
        <td><%=periodicals.get(3).getPeriodicity()%></td>
        <td><%=periodicals.get(3).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(3).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(3).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(4).getTitle()%></th>
        <td><%=periodicals.get(4).getPaperType()%></td>
        <td><%=periodicals.get(4).getPeriodicity()%></td>
        <td><%=periodicals.get(4).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(4).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(4).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(5).getTitle()%></th>
        <td><%=periodicals.get(5).getPaperType()%></td>
        <td><%=periodicals.get(5).getPeriodicity()%></td>
        <td><%=periodicals.get(5).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(5).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(5).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(6).getTitle()%></th>
        <td><%=periodicals.get(6).getPaperType()%></td>
        <td><%=periodicals.get(6).getPeriodicity()%></td>
        <td><%=periodicals.get(6).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(6).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(6).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(7).getTitle()%></th>
        <td><%=periodicals.get(7).getPaperType()%></td>
        <td><%=periodicals.get(7).getPeriodicity()%></td>
        <td><%=periodicals.get(7).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(7).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(7).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(8).getTitle()%></th>
        <td><%=periodicals.get(8).getPaperType()%></td>
        <td><%=periodicals.get(8).getPeriodicity()%></td>
        <td><%=periodicals.get(8).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(8).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(8).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(9).getTitle()%></th>
        <td><%=periodicals.get(9).getPaperType()%></td>
        <td><%=periodicals.get(9).getPeriodicity()%></td>
        <td><%=periodicals.get(9).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(9).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(9).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(10).getTitle()%></th>
        <td><%=periodicals.get(10).getPaperType()%></td>
        <td><%=periodicals.get(10).getPeriodicity()%></td>
        <td><%=periodicals.get(10).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(10).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(10).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(11).getTitle()%></th>
        <td><%=periodicals.get(11).getPaperType()%></td>
        <td><%=periodicals.get(11).getPeriodicity()%></td>
        <td><%=periodicals.get(11).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(11).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(11).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(12).getTitle()%></th>
        <td><%=periodicals.get(12).getPaperType()%></td>
        <td><%=periodicals.get(12).getPeriodicity()%></td>
        <td><%=periodicals.get(12).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(12).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(12).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(13).getTitle()%></th>
        <td><%=periodicals.get(13).getPaperType()%></td>
        <td><%=periodicals.get(13).getPeriodicity()%></td>
        <td><%=periodicals.get(13).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(13).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(13).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(14).getTitle()%></th>
        <td><%=periodicals.get(14).getPaperType()%></td>
        <td><%=periodicals.get(14).getPeriodicity()%></td>
        <td><%=periodicals.get(14).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(14).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(14).getCharacteristic().getCover()%></td>
    </tr>
    <tr>
        <th scope="row"><%=periodicals.get(15).getTitle()%></th>
        <td><%=periodicals.get(15).getPaperType()%></td>
        <td><%=periodicals.get(15).getPeriodicity()%></td>
        <td><%=periodicals.get(15).getCharacteristic().isColourful()%></td>
        <td><%=periodicals.get(15).getCharacteristic().getCapacity()%></td>
        <td><%=periodicals.get(15).getCharacteristic().getCover()%></td>
    </tr>
    </tbody>
</table>
<script src="assets/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
</body>
</html>