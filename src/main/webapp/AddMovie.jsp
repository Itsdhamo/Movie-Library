<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->	
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="images/moviecornerlogo.jpg" type="image/x-icon">
    <title>Movies libraries</title>
  </head>
  <body style="background-image: url(images/addmovieimage.jpg);background-repeat: no-repeat;background-size: 100%">
 <center><div style="border: 5px solid grey; width: 450px; margin-top: 100px">  
 <center>  <h2 style="color: white">Add Movie</h2><br>
<form action="savemovie" method="post"enctype="multipart/form-data">
    <table style="color: white">
    <tr>
    <td>Movie id</td><td><input type="text" name="movieid"></td>
    </tr>
    <tr>
    <td>Movie Name</td><td><input type="text" name="moviename"></td>
    </tr>
    <tr>
    <td>Movie Price</td><td><input type="text" name="movieprice"></td>
    </tr>
    <tr>
    <td>Movie Ratings</td><td><input type="text" name="movierating"></td>
    </tr>
    <tr>
    <td>Movie Generes</td><td><input type="text" name="moviegeneres"></td>
    </tr>
    <tr>
    <td>Movie Language</td><td><input type="text" name="movielanguage"></td>
    </tr>
    <tr>
    <td>Movie Image</td><td><input type="file" name="movieimage"></td>
    </tr>
    <tr>
    <td>Movie Image1</td><td><input type="file" name="movieimage1"></td>
    </tr>
    <tr>
    <td>Movie Image2</td><td><input type="file" name="movieimage2"></td>
    </tr>
    </table>
    <input type="submit"></form></center><br>
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