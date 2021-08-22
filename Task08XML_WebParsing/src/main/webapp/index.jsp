<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/bootstrap-4.3.1-dist/css/bootstrap.css">
    <title>Task08XMLWebParsing</title>
</head>
<body>
<div style="text-align: center;">
<h3>This is a XML parser page</h3>
    <form method="post" action="upload" enctype="multipart/form-data">
        Select file to upload: <input type="file" name="file" size="60" /><br />
        <br />
        <select name="parseType" title="Parser type">
            <option value="dom">DOM</option>
            <option value="sax">SAX</option>
            <option value="stax">StAX</option>
        </select>
        <input type="submit" name="Parse">
    </form>
<script src="assets/bootstrap-4.3.1-dist/js/bootstrap.js"></script>
</div>
</body>
</html>
