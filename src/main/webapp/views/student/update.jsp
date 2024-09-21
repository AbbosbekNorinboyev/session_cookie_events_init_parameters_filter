<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Update</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post">
    <div class="mt-5 mb-3 m-5">
        <label for="name" class="form-label">Full name</label>
        <input id="name" type="text" name="name" class="form-control" value="${build.getFull_name()}"/>
    </div>
    <div class="mt-0 mb-3 m-5">
        <label for="age" class="form-label">Age</label>
        <input id="age" type="number" name="age" class="form-control" value="${build.getAge()}"/>
    </div>
    <div class="mt-0 mb-3 m-5">
        <label for="id" class="form-label">Group id</label>
        <input id="id" type="number" name="id" class="form-control" value="${build.getGroup_id()}"/>
    </div>
    <div class="mt-0 mb-3 m-5">
        <button type="submit" class="btn btn-success">Update</button>
        <a href="/student/list" class="btn btn-danger">Back</a>
    </div>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
