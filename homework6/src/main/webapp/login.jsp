<%--
  Created by IntelliJ IDEA.
  User: itvdn
  Date: 2019-07-02
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>

    <h2>Login Page!</h2>
    <h3>Enter your credentials:</h3>
<%--    <form action="/login" method="post">--%>
    <form action="/perform_login" method="post">
        <p>Login: </p>
        <input type="text" name="username"/><br/>
        <p>Password: </p>
        <input type="password" name="password">
        <br/>
        <br/>
        <input type="submit" value="Login">
    </form>
    <p><a href="/index.jsp">Go to main...</a></p>

</body>
</html>
