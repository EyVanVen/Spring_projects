<%@ page import="task1.User" %><%--
  Created by IntelliJ IDEA.
  User: BVA
  Date: 08.07.2021
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="/form" method="post" modelAttribute="${user}">
  <p>Name : <input type="text" name="name"></p>
  <p>Surname : <input type="text" name="surname"></p>
  <p>Years : <input type="number" name="age"></p>
  <input type="submit" value="Submit">
  <%--User user1 = new User(${user.name}, ${user.surname}, ${user.years});/--%>
</form>
</body>
</html>
