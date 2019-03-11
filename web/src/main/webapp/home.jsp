<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 3/8/2019
  Time: 12:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ import="User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <h1>HOME</h1>


</head>
<body>

<%

    User us= (User)session.getAttribute ("user");%>
%>
    Bienvenido <%=us.getUserName;%>

</body>
</html>
