<%@page import="java.util.List"%>
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

    <title>User Home</title>
  </head>
  <body style=" background-image: url(images/image2.png);background-repeat:round;position: relative;background-attachment: fixed;">
   <% int userid=(int)request.getAttribute("userid");%>
   <% String username=(String)request.getAttribute("username"); %>
  <div style="position: sticky; top: 0px"> <nav class="navbar navbar-light bg-dark">
  <div class="container-fluid">
   <img src="images/ciniimage.png" alt="" width="40" height="40" class="d-inline-block align-text-top">
      <i style="color: white;margin-left:-310px"><h4>User Corner</h4></i>
      <i style="color: red;margin-left:-310px"><h4>Hii <%=username %></h4></i>
         <button type="button" class="btn btn-warning btn-lg" style="width: 160px; height:40px; line-height: 12px;margin-right:-310px "><a class="navbar-brand" href="PurchasedMovies?userid=<%= userid %>" id="purchasesmovies" style="font-size: 15px; text-align: center;">Purchased Movies</a></button>
    <button type="button" class="btn btn-danger btn-lg" style="width: 90px; height:40px; line-height: 12px;margin-right:-310px"><a class="navbar-brand" href="userlogout" id="logout" style="font-size: 15px; text-align: center;color: white">Log Out</a></button>
    <form class="d-flex" action="SearchMovie" method="get" enctype="multipart/form-data">
      <input class="form-control me-2" type="text" placeholder="Search with movieid" aria-label="Search" name="movieid">
   <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav></div> 
 <br>	
  <% List<Movie> movies =(List)request.getAttribute("movies"); %>
  <div class="container"> 
    <div class="row " style="row-gap: 50px">
    <% for(Movie m:movies){ %>
     <% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
    <div class="col-3">
    <div class="card" style="width: 13rem; border-radius: 50px;position: static">
  <img src="data:image/jpeg;base64, <%= base64image %>" class="card-img-top" alt="..." style="height: 200px; border-top-left-radius: 50px; border-top-right-radius:50px ">
  <div class="card-body" style="background-color:grey; ">
 <center><h3 class="card-title" style="font-size: 20px;color:white;height: 2px; line-height: 5px"><%= m.getMoviename() %></h3></center>    
   </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item" style="height: 35px;background-color: black;color: red;position: static"><b><i>Id</i></b>=<%= m.getMovieid() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: white;position: static"><b><i>Name</i></b>=<%= m.getMoviename() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: red;position: static"><b><i>Price</i></b>=<%=  m.getMovieprice() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: white;position: static"><b><i>Ratings</i></b>=<%= m.getMovieratings() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: red;position: static"><b><i>Generes</i></b>=<%= m.getMoviegeneres() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: white;position: static"><b><i>Languages</i></b>=<%= m.getMovielanguage() %></li> 
  </ul>
  <div class="card-body" style="background-color: grey ;border-bottom-left-radius: 50px;border-bottom-right-radius: 50px;">
<center>
  <a class="btn btn-primary" href="buymoviecenter?id=<%=m.getMovieid()%>&userid=<%= userid %>" role="button">BUY</a></center>   
  </div>
</div>
    </div>
     <%} %>
    </div>
    </div>
    <div id="datediv" style="height: 30px ">
    <p id="date&time"></p></div>
     <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

<script >
var date1=document.getElementById("date");
var d=new Date();
var p=document.getElementById("date&time");
document.body.append(p);
p.textContent="Date = "+d.toLocaleString();
p.style.color="gold";
p.style.textAlign="center";
</script>


    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>
 