<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student List</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form>
    <div class="container">
        <div class="row">
            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Create at</th>
                        <th scope="col">Age</th>
                        <th scope="col">Group id</th>
                        <th scope="col">Created by(Data base user id)</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${studentList}" var="studentList">
                            <tr>
                                <td><c:out value="${studentList.getId()}"/></td>
                                <td><c:out value="${studentList.getFull_name()}"/></td>
                                <td><c:out value="${studentList.getCreated_at()}"/></td>
                                <td><c:out value="${studentList.getAge()}"/></td>
                                <td><c:out value="${studentList.getGroup_id()}"/></td>
                                <td><c:out value="${studentList.getCreated_by()}"/></td>
                                <td>
                                    <a href="/delete/student/${studentList.getId()}" class="btn btn-danger">Delete</a>
                                    <a href="/update/student/${studentList.getId()}" class="btn btn-warning">Update</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<script page="/fragments/js/bootstrap.min.js"></script>
</body>
</html>
