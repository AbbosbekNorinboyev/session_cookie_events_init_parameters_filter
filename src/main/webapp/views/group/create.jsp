<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Create</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post">
    <div class="mt-5 mb-3 m-5">
        <label for="name" class="form-label">Group name</label>
        <input id="name" type="text" name="name" class="form-control"/>
        <label for="count" class="form-label">Count</label>
        <input id="count" type="number" name="count" class="form-control"/>
        <button type="submit" class="btn btn-success mt-3">Save</button>
    </div>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
