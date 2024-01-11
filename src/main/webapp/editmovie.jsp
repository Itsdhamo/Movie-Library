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
<body>
	<% Movie m = (Movie)request.getAttribute("movie");%>
	<form action="updatemovie" method="post" enctype="multipart/form-data">
		Movie Id<input type="text" name="movieid" value="<%= m.getMovieid() %>" readonly><br>
		Movie Name<input type="text" name="moviename" value="<%= m.getMoviename() %>"><br> 
		Movie Price<input type="text" name="movieprice" value="<%= m.getMovieprice() %>"><br> 
		Movie Ratings<input type="text" name="movierating" value="<%= m.getMovieratings() %>"><br> 
		Movie Generes<input type="text" name="moviegeneres" value="<%= m.getMoviegeneres() %>"><br> 
		Movie Language<input type="text" name="movielanguage" value="<%= m.getMovielanguage() %>"><br>
		Movie Image<input type="file" name="movieimage"><br> 
		 
		
		<% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
        <img src="data:image/jpeg;base64, <%= base64image %>" height="100px" width="100px">
        <input type="submit">
</body>
</html>