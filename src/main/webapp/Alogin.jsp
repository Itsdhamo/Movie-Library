<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="Alogin.css">
<body>
<div> 	
<h1>Admin Login</h1>
<form action="Adminlogin" method="post">
<label class="input">Admin email</label> <input type="text" name="adminmail" id="email"><br>
<label class="input">Admin password</label> <input type="text" name="adminpassword" id="password"><br>
<input type="submit" id="submit">
<% String message=(String)request.getAttribute("message"); %>
<% if(message != null){ %>
<p><%= message  %></p>
<%} %>
</div>
</body>
</html>