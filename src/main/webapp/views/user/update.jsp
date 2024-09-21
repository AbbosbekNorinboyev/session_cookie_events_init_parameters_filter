<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Update</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="username" class="form-label">Username</label>
        <input id="username" type="text" name="username" class="form-control" value="${build.getUsername()}"/>
    </div>
    <button type="submit" class="btn btn-success mt-3">Update</button>
    <a href="/user/list" class="btn btn-danger mt-3">Back</a>
</form>
<script page="/fragments/js/bootstrap.min.js"/>
</body>
</html>
