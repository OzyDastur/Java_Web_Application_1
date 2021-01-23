<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Anton&family=Archivo+Black&family=Righteous&family=Ultra&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Pathway+Gothic+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles/login.css">
    <title>Login Page</title>
  </head>
  <body>

  <div class="container-fluid">
    <div id="header">
		Log In
		<p>Employee Login Form</p>
	</div>
    
  <div class="login-wrapper">
       
        <form action="LoginServlet" method="POST">
            <h1> Log In</h1>
        <div class="mb-3">
           
            <input  type="text" class="form-control" name="email" placeholder="Email" >
            
        </div>
     
        <div class="mb-3">
            
            <input  type="password" class="form-control" name="password" placeholder="Password">
        </div>
       
        <button type="submit" class="btn bt-primary">Log In</button><br><br>
       
  
        <div class="singup-link">
            <span>A new member? Sign up here </span><a href="signup.jsp">Signup</a>
        </div>
        </form>
    
    </div>
   </body>
   </html>