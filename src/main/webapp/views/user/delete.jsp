<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Delete</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="m-5">
    <div class="alert alert-danger">
        <h1>Are you sure delete this user <i><c:out value="${build.getUsername()}"/></i></h1>
    </div>
    <button type="submit" class="btn btn-success">Delete</button>
    <a href="/user/list" class="btn btn-danger">Back</a>
</form>
<script page="/fragments/js/bootstrap.min.js"/>
</body>
</html>
