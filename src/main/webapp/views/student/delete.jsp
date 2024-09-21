<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Delete</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="m-5 mb-3">
    <div class="alert alert-danger">
        <h1>Are you sure delete this <i><c:out value="${build.getFull_name()}"/></i></h1>
    </div>
    <button type="submit" class="btn btn-success">Delete</button>
    <a href="/student/list" class="btn btn-danger">Back</a>
</form>
<script page="/fragments/js/bootstrap.min.js"/>
</body>
</html>
