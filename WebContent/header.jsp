<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-pQQkAEnwaBkjpqZ8RU1fF1AKtTcHJwFl3pblpTlHXybJjHpMYo79HY3hIi4NKxyj" crossorigin="anonymous"></script>
    
    
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Anton&family=Archivo+Black&family=Righteous&family=Ultra&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Pathway+Gothic+One&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="styles/header.css">
    <title>Header</title>
</head>
<body>
<%
	//The code in this section prevents going back after logout
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	
	String email = (String)session.getAttribute("email");
	
	if(email == null){
		response.sendRedirect("login.jsp");
	}
	
%>

    <div class="container-fluid" >
        
        
    <nav class="navbar navbar-expand-md  navbar-dark bg-dark " >
    
        
        <button class="navbar-toggler " data-bs-toggle="collapse" data-bs-target="#hamburger">
            <span class="navbar-toggler-icon "></span>
        </button>
       
        <div class="collapse navbar-collapse pt-1 pb-1" id="hamburger">
       
        
        <form class="d-flex">
        <input class="form-control me-2 " type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success bg-danger text-white" type="submit">Search</button>
        </form>
            
            <ul class="navbar-nav ms-auto pt-1 pb-1" >
               
                <li class="nav-item "><a href="#" class="nav-link">Home</a></li>
                <li class="nav-item "><a href="course.jsp" class="nav-link ">Course Table</a></li>
                <li class="nav-item "><a href="#" class="nav-link ">Future Link</a></li>
                <li class="nav-item dropdown "><a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown" data-bs-target="#caret" >
                    Search
                    <span class="caret"></span>
                </a>
                    <ul class="dropdown-menu" aria-labelledby="caret">
                        <li><a href="#" class="drodown-item"> Link-1 </a></li>
                        <li><a href="#" class="drodown-item"> Link-2</a></li>
                        <li><a href="#" class="drodown-item"> Link-3</a></li>
                        <li><a href="#" class="drodown-item"> Link-4</a></li>
                    </ul>
            
                </li>
               
                <li class="nav-item "><a href="#" class="nav-link">About</a></li>
                <li class="nav-item "><a href="#" class="nav-link ">Contact</a></li>
                <form action="logout.jsp" method="POST">
                    <button type="submit"  class="btn btn-light" ><a href="http://localhost:8080/registration/logout.jsp">Logout</a></button>
                </form>
            </ul>
        
        
        </div>
    
        
    </nav>
    </div>