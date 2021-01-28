<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
	crossorigin="anonymous"></script>

<link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Alfa+Slab+One&family=Anton&family=Archivo+Black&family=Righteous&family=Ultra&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Pathway+Gothic+One&display=swap" rel="stylesheet">
<link rel="stylesheet" href="styles/signup.css">
<title>Courses</title>
</head>
<body>
	<% 
		String successMessage = request.getParameter("successMessage");
	
		if(successMessage == null){
			out.print("");
		}
		else{
			%><div class="alert alert-success" role="alert"><% 
			out.print(successMessage);
			%></div><%
		}	
	%>
<div class="container">
	<div class="row justify-content-center">
        <form action="CreateServlet" method="POST" class="form">
        <div class="form-group">
            <div>
                <h3>Manage Your Courses</h3>
               
            </div>
            
            <label for="course_name" class="course_name">Name of the couse</label><br>
            <input class="form-control" type="text" name="course_name" value=""><br>
        </div> 
        <div class="form-group">
            <label for="department" class="department">Department</label><br>
            <input class="form-control" type="text" name="department" value=""><br>
        </div>  
        <div class="form-group"> 
           
            <?php if($edit_state==false):?>
                <input type="submit" name="save" value="Save" class="btn btn-success">  </button>
                
            <?php else: ?>
                <input type="submit" name="update" value="Update" class="btn btn-primary"></button>
            <?php endif; ?>
        </div>
        </form>
        </div>
    </div>
	
</body>
</html>
</body>
</html>