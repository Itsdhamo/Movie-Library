<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 Not Found</title>
 <style>
        body {
            background-color:grey;
        }

        .error-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .header {
            text-align: center;
            margin-bottom: 30px;
        }

  
        #img{
        height: 300px;
        width: 300px;
        }
    </style>
</head>
<body>

<div class="container error-container">
    <div class="header">
        <h1>Error 404 - not found</h1>
    </div>

    <div class="img-container">
        <img src="https://w7.pngwing.com/pngs/813/610/png-transparent-http-404-graphy-error-others-3d-computer-graphics-photography-sign.png" alt="Not Found Image" id="img">
    </div>
</body>
</html>