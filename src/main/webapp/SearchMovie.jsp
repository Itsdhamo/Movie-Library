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

    <title>Searched Movie</title>
  </head>
  <body style="background-image: url(images/image2.png);background-repeat: no-repeat; opacity: 0.9">
    <% Movie m = (Movie)request.getAttribute("movie");%>
  <div class="row" style="row-gap: 50px">
     <% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
   <center><i><h1 style="color: white;margin-top: 25px">Your Searched Movie</h1	></i></center>   
    <div class="col-3">
  <center>  <div class="card" style="width: 15rem; border-radius: 50px; margin-left: 520px;border: 3px dashed white;margin-top: -40px">
  <img src="data:image/jpeg;base64, <%= base64image %>" class="card-img-top" alt="..." style="height: 200px; border-top-left-radius: 50px; border-top-right-radius:50px ">
  <div class="card-body" style="background-color:grey; ">
 <center><h3 class="card-title" style="font-size: 20px;color:white;height: 2px; line-height: 5px"><%= m.getMoviename() %></h3></center>    
   </div>
    
  <ul class="list-group list-group-flush" style="border-bottom-left-radius: 50px;border-bottom-right-radius: 50px">
    <li class="list-group-item" style="height: 35px;background-color: black;color: red;"><b><i>Id</i></b>=<%= m.getMovieid() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: white;"><b><i>Name</i></b>=<%= m.getMoviename() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: red;"><b><i>Price</i></b>=<%=  m.getMovieprice() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: white;"><b><i>Ratings</i></b>=<%= m.getMovieratings() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: red;"><b><i>Generes</i></b>=<%= m.getMoviegeneres() %></li> 
    <li class="list-group-item" style="height: 35px;background-color: black;color: white;"><b><i>Languages</i></b>=<%= m.getMovielanguage() %></li> 
  </ul>
     
</div></center> 
    </div>
    </div>
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