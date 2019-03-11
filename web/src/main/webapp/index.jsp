<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
</head>
<body>

<form action="login" method="post">

    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    <input type="submit" value="Login">
</form>

<form action="register" method="post">

    Username: <input type="text" name="user">
    <br>
    Password: <input type="password" name="pwd">
    <br>
    Email: <input type="text" name="email">
    <br>
    <input type="submit" value="Register">
</form>

</body>
</html>