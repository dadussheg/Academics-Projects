<%@page import="com.jdbc.User1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
<style>
body{
background-image: url(last.jpg);
}
</style>
</head>
<body>
<h1>Login Success</h1>
<%User1 user=(User1)session.getAttribute("user");%>
<h3>Welcome</h3> &nbsp;<%=user.getName()%>
<br>
RollNo &nbsp;<%=user.getRollno() %>

<br>
 
</body>
</html>