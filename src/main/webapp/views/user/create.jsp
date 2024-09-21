<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Create</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post">
    <div class="mb-3 mt-0 m-5">
        <label for="username" class="form-label">Username</label>
        <input id="username" type="text" name="username" class="form-control"/>
    </div>
    <button type="submit" class="btn btn-success mt-0 m-5">Save</button>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
