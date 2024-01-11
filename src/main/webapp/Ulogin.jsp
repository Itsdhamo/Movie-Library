<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Ulogin.css">
</head>
<body>
<div> 
<h1>User Login</h1>
<form action="Userlogin" method="post">
<label class="input">User email</label><input type="text" name="usermail" id="email" ><br>
<label class="input">User password</label><input type="text" name="userpassword" id="password" ><br>
<input type="submit" id="submit">
<% String message=(String)request.getAttribute("message"); %>
<% if(message != null){ %>
<%= message %>
<%} %>
</div>
</body>
</html>