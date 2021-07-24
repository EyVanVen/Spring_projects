
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Id Result</title>
</head>
<body>

<c:forEach items="${list}" var="user">
    <h2>${user.id} | ${user.login} | ${user.email} | ${user.password}</h2>
</c:forEach>
<hr>

<h3><a href="../users/findId">Search for another one...</a></h3>
<h3><a href="../index.jsp">Go to main...</a></h3>

</body>
</html>
