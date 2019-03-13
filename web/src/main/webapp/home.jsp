<%@ page import="com.capgemini.heskuelita.entity.Human" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="US-ASCII">
    <title>Login Page</title>
</head>
<body>

<%Human us = (Human)session.getAttribute ("user");%>
Bienvenido : <%=us.getUser_name() + " [" + us.getEmail()  + "]"%>
</body>
</html>