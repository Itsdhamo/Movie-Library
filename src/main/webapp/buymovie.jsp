<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="images/moviecornerlogo.jpg" type="image/x-icon">
    <title>Buy Movie</title>
  </head>
  <body style="background-color:black">
  <center><h3 style="color:red;font-style: italic;margin-top: 30px ">PURCHASE MOVIE</h3></center>
 <% int userid=(int)request.getAttribute("userid");%>
 <% Movie m = (Movie)request.getAttribute("movies");%>
<% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
<center> <div style="border: 3px dotted white;width: 350px"> 
<center> <img src="data:image/jpeg;base64, <%= base64image %>" height="150px" width="150px" style="margin-top: 20px"></center>
<center> <table style="margin-top: 15px">
<tr>
<td style="color: red">Movie Id</td><td style="color: white;"><%= m.getMovieid() %></td>
<tr>
<tr>
<td style="color: red">Movie Name</td><td style="color: white;"><%= m.getMoviename() %></td>
<tr>
<tr>
<td style="color: red">Movie Price</td><td style="color: white;"><%= m.getMovieprice() %></td>
<tr>
<tr>
<td style="color: red">Movie Ratings</td><td style="color: white;"><%= m.getMovieratings() %></td>
<tr>
<tr>
<td style="color: red">Movie Generes</td><td style="color: white;"><%= m.getMoviegeneres() %></td>
<tr>
<tr>
<td style="color: red">Movie Language</td><td style="color: white;"><%= m.getMovielanguage() %></td>
<tr></table></center>
<img src="images/paytm symbol.jpg" style="height: 40px;width: 60px">
<img src="images/gpay.png" style="height:40px;width: 60px;margin-right: 100px"><br><br>
<center><a class="btn btn-primary" href="buymovie?id=<%=m.getMovieid()%>&userid=<%= userid %>" role="button">BUY</a></center>	
</div></center>
<% String message=(String)request.getAttribute("message"); %>
<% if(message != null){ %>
<h3 style="color: white ;text-align:center;font-size: 30px;margin-top: 10px"><%= message  %></h3>
<%} %>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>