 <!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="images/moviecornerlogo.jpg" type="image/x-icon">

    <title>User signup</title>
  </head>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" />
     <style>
     .input-container i {
  padding: 10px;
  color: white;
  cursor: pointer;
}
.input-container {
  width: 200px;
  border-radius: 3px;
  display: flex;
  height:31px;
 
}
.input-container input {
  padding: 10px;
  width: 190px;
  font-size: 16px;
   height:31px;
  outline: none;
  color: #333;
}
     @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@100;300;400;500;600;700;800&display=swap");
     </style>
  <body>
    <body style="background-image: url(images/usered.jpg); background-repeat: no-repeat; background-size: 100%">
  <center>   <div style="border: 1px  white; width: 400px; margin-top: 150px; color: white" >
<h2 style="color: gold;"> UserSignUp</h2>

<form action="usersignup" method="post"><br>
<table>
<tr><td>User Id</td>
<td><input type="text" name="userid" placeholder="Enter ID eg:1,2,3"></td>
</tr>
<tr><td>User Name</td>
<td><input type="text" name="username" placeholder="Enter Name"></td>
</tr>
<tr><td>User Contact</td>
<td><input type="text" name="usercontact" placeholder="Enter Contact"></td>
</tr>
<tr><td>User Mail</td>
<td><input type="text" name="usermail" placeholder="Enter Mail Id"></td>
</tr>
<tr><td>User Password</td>
<td>
<div class="input-container">
      <input type="password" name="userpassword" id="password" placeholder="Enter Password"/>
      <i class="fa fa-eye" id="toggleBtn" ></i>
    </div></td>
</tr>
</table>
 <br>
<button type="submit" class="btn btn-warning">Submit</button>
<a href="User.jsp"><button type="button" class="btn btn-warning" style="width: 80px">Back</button></a>
</form>
</div></center>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script>
    const toggleBtn = document.querySelector("#toggleBtn");
    const input = document.querySelector(".input-container input");

    var password = true;
    toggleBtn.addEventListener("click", function () {
      if (password) {
        input.setAttribute("type", "text");
        toggleBtn.classList.remove("fa-eye");
        toggleBtn.classList.add("fa-eye-slash");
        password = false;
      } else {
        input.setAttribute("type", "password");
        toggleBtn.classList.remove("fa-eye-slash");
        toggleBtn.classList.add("fa-eye");
        password = true;
      }
    });
    </script>
    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>