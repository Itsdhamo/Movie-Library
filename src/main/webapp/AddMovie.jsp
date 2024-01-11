<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Add Movie</h2>
<form action="savemovie" method="post"enctype="multipart/form-data">
Movie Id<input type="text" name="movieid"><br>
Movie Name<input type="text" name="moviename"><br>
Movie Price<input type="text" name="movieprice"><br>
Movie Ratings<input type="text" name="movierating"><br>
Movie Generes<input type="text" name="moviegeneres"><br>
Movie Language<input type="text" name="movielanguage"><br>
Movie Image<input type="file" name="movieimage"><br>
<input type="submit">
</form>
</body>
</html>