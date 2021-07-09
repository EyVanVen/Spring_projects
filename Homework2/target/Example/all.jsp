<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List of users : </h1>


<c:forEach items="${list}" var="user" varStatus="status">
<h2>User: ${status.index} ${user.name} ${user.surname} ${user.age} </h2>
</c:forEach>

<h2>Total: ${total}</h2>

</body>
</html>
