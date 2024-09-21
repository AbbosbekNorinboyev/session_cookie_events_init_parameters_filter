<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
    <link rel="stylesheet" href="/fragments/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Username</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${userList}" var="userList">
                        <tr>
                            <td><c:out value="${userList.getId()}"/></td>
                            <td><c:out value="${userList.getUsername()}"/></td>
                            <td>
                                <a href="/delete/user/${userList.getId()}" class="btn btn-warning">Delete</a>
                                <a href="/update/user/${userList.getId()}" class="btn btn-danger">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<script page="/fragments/js/bootstrap.min.js"/>
</body>
</html>
