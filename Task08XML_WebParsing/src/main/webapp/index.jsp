<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Task08XMLWebParsing</title>
</head>
<body>
<h3>This is a XML parser page</h3>
<form action="XMLServlet" method="post" enctype="multipart/form-data">
    <input required="required" type="file" name="xmlFile"><br>
    <p>
        <mark>Select type of parser</mark>
    </p>
    <input type="radio" id="DOM" name="radioButton" value="DOM">
    <label for="DOM">DOM</label><br>
    <input type="radio" id="SAX" name="radioButton" value="SAX">
    <label for="SAX">SAX</label><br>
    <input type="radio" id="STAX" name="radioButton" value="StAX">
    <label for="STAX">StAX</label><br>
    <input type="submit" value="Parse">
</form>
</body>
</html>
