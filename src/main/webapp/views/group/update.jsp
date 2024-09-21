<%--
  Created by IntelliJ IDEA.
  User: norin
  Date: 1/7/2024
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Update</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post">
    <div class="mt-5 mb-3 m-5">
        <label for="name" class="form-label">Group name</label>
        <input id="name" type="text" name="name" class="form-control" value="${build.getGroup_name()}"/>
        <label for="count" class="form-label">Count</label>
        <input id="count" type="number" name="count" class="form-control" value="${build.getCount()}"/>
        <button type="submit" class="btn btn-success mt-3">Update</button>
        <a href="/group/list" class="btn btn-danger mt-3">Back</a>
    </div>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
