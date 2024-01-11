<%@page import="java.util.List"%>
<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <link rel="stylesheet" href="Home.css">
<body>
<h1>Welcome</h1>
<a href="AddMovie.jsp" id="addmovie">Add Movie</a>

<% List<Movie> movies =(List)request.getAttribute("movies"); %>

<table border="1px" id="table">
<tr>
<td class="common">Id</td>
<td class="common">Name</td>
<td class="common">Price</td>
<td class="common">Ratings</td>
<td class="common">Generes</td>
<td class="common">Language</td>
<td class="common">Image</td>
<td class="common">Delete</td>
<td class="common">Edit</td>
</tr>

<% for(Movie m:movies){ %>
<tr>
<td><%= m.getMovieid() %></td>
<td><%= m.getMoviename() %></td>
<td><%= m.getMovieprice() %></td>
<td><%= m.getMovieratings() %></td>
<td><%= m.getMoviegeneres() %></td>
<td><%= m.getMovielanguage() %></td>
<% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<td><img src="data:image/jpeg;base64, <%= base64image %>" height="100px" width="100px"></td>
<td><a href="deletemovie?id=<%= m.getMovieid()%>">delete</a></td>
<td><a href="editmovie?id=<%= m.getMovieid()%>">edit</a></td>
</tr>
<%} %>
</table>
</body>
</html>