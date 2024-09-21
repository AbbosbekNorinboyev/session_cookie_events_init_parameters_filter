<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: norin
  Date: 1/7/2024
  Time: 10:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group Delete</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="m-5">
    <div class="alert alert-danger">
        <h1>Are you sure delete this <i><c:out value="${build.getGroup_name()}"/></i></h1>
    </div>
    <button type="submit" class="btn btn-success">Delete</button>
    <a href="/group/list" class="btn btn-danger">Back</a>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
