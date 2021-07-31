<%--
  Created by IntelliJ IDEA.
  User: Oched
  Date: 27.07.2021
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<body>
<form action="/registration" method="post" modelAttribute="${user}">
    <p>Login : <input type="text" name="login"></p>
    <p>Email : <input type="text" name="email"></p>
    <p>Password : <input type="text" name="password"></p>
    <p>Role :
        <select name="role">
            <option selected value="USER">User</option>
            <option value="ADMIN">Admin</option>
        </select></p>
    <input type="submit" value="Pass data">
</form>

<p><a href="/index.jsp">Go to main...</a></p>
</body>

</body>
</html>
