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

    <title>Update Movie</title>
  </head>
  <body style="background-image: url(images/netflix.jpg); background-size: 100%;opacity: 0.8">
 <center>  <% Movie m = (Movie)request.getAttribute("movie");%>
  <% String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
  <% String base64image1=new String(Base64.getEncoder().encode(m.getMovieimage1())); %>
  <% String base64image2=new String(Base64.getEncoder().encode(m.getMovieimage2())); %>
  <form action="updatemovie" method="post" enctype="multipart/form-data">
    <div class="card" style="width: 20rem;margin-top: 15px;border-radius: 50px">
    
    <div id="carouselExampleInterval" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="10000">
      <img src="data:image/jpeg;base64, <%= base64image %>" class="d-block w-100" alt="..." style="height: 200px; border-top-left-radius: 50px; border-top-right-radius:50px ">
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="data:image/jpeg;base64, <%= base64image1 %>" class="d-block w-100" alt="..." style="height: 200px; border-top-left-radius: 50px; border-top-right-radius:50px ">
    </div>
    <div class="carousel-item">
      <img src="data:image/jpeg;base64, <%= base64image2 %>" class="d-block w-100" alt="..." style="height: 200px; border-top-left-radius: 50px; border-top-right-radius:50px ">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleInterval" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>    
  <div class="card-body" style="height: 60px;background-color:black;color: white">
    <h3 class="card-title"><%=m.getMoviename()  %></h3>
  </div>
  <table style="background-color: black; color: white">
  <tr>
  <td>Movie Id</td><td><input type="text" name="movieid" value="<%= m.getMovieid() %>" readonly></td>
  </tr>
  <tr>
  <td>Movie Name</td><td><input type="text" name="moviename" value="<%= m.getMoviename() %>"></td>
  </tr>
  <tr>
  <td>Movie Price</td><td><input type="text" name="movieprice" value="<%= m.getMovieprice() %>"></td>
  </tr>
  <tr>
  <td>Movie Ratings</td><td><input type="text" name="movierating" value="<%= m.getMovieratings() %>"></td>
  </tr>
  <tr>
  <td>Movie Generes</td><td><input type="text" name="moviegeneres" value="<%= m.getMoviegeneres() %>"></td>
  </tr>
  <tr>
  <td>Movie Language</td><td><input type="text" name="movielanguage" value="<%= m.getMovielanguage() %>"></td>
  </tr>
  </table>
  <div class="card-body" style="background-color: black;border-bottom-left-radius: 50px;border-bottom-right-radius: 50px">
   <input type="file" name="movieimage"> 
    <input type="file" name="movieimage1"> 
     <input type="file" name="movieimage2"> 
    <button class="btn btn-success" type="submit">Submit</button>
  </div>
</div></center>
  
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