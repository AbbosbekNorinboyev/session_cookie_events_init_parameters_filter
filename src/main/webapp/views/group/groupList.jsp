<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: norin
  Date: 1/7/2024
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group List</title>
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
                        <th scope="col">Group name</th>
                        <th scope="col">Created at</th>
                        <th scope="col">Count</th>
                        <th scope="col">Created by(Data base user id)</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${groupsList}" var="groupsList">
                        <tr>
                            <td><c:out value="${groupsList.getId()}"/></td>
                            <td><c:out value="${groupsList.getGroup_name()}"/></td>
                            <td><c:out value="${groupsList.getCreated_at()}"/></td>
                            <td><c:out value="${groupsList.getCount()}"/></td>
                            <td><c:out value="${groupsList.getCreated_by()}"/></td>
                            <td>
                                <a href="/delete/group/${groupsList.getId()}" class="btn btn-warning">Delete</a>
                                <a href="/update/group/${groupsList.getId()}" class="btn btn-danger">Update</a>
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
