<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Oched
  Date: 07.07.2021
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List of users</title>
</head>
<body>
    <h2>List of users : </h2>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Email</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="user" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${user.login}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <hr>

    <p><a href="../users/add">Go to users form...</a></p>
    <p><a href="../index.jsp">Go to main...</a></p>

</body>
</html>
