<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="styles/signup.css">
<title>Registration</title>
</head>
<body>

	<div id="header">
		Sign Up
		<p>Student Signup Form</p>
	</div>
	<div class="signup-wrapper" >

		<form id="form" action="SignupServlet" method="POST">


			<h3>Sign Up</h3>

			<div class="mb-3">

			<input id="username" type="text" class="form-control" name="username" placeholder="Username">

			</div>
			<div class="mb-3">

				<input id="email" type="text" class="form-control" name="email" placeholder="Email">
			
			</div>
			
				<% 
					String invalidEmail = request.getParameter("invalidEmail");
				
					if(invalidEmail == null){
						out.print("");
					}
					else{
						%><div class="alert alert-danger" role="alert"><% 
						out.print(invalidEmail);
						%></div><%
					}	
				%>
			

			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender" id="male" value="Male" checked> 
				<label class="form-check-label" for="male"> Male</label>
			</div>
			<div class="form-check">
				<input class="form-check-input" type="radio" name="gender" id="female" value="Female"> 
				<label class="form-check-label" for="female">Female</label>
			</div>

			<div class="mb-3">

				<input id="password" type="password" class="form-control" name="password" placeholder="Password">
			</div>
			
				<%
					String invalidPassword = request.getParameter("invalidPassword");
					
						if(invalidPassword == null){
							out.print("");
						}
						else{
							%><div class="alert alert-danger" role="alert"><%
							out.print(invalidPassword);
							%></div><%
						}
				
				%>
			
			<div class="mb-3">

				<input id="confirm_password" type="password" class="form-control" name="confirm_password" placeholder="Confirm Password">
			</div>
			
				<% 
					String passwordMismatch = request.getParameter("passwordMismatch");
				
					if(passwordMismatch == null){
						out.print("");
					}
					else{
						%><div class="alert alert-danger" role="alert"><%
						out.print(passwordMismatch);
						%></div><%
					}	
				%>
			
			<button id="signup" type="submit" class="btn btn-primary">Signup</button>
			<br>
			<div class="login-link">
				<span>Already a member? Sign in here </span><a href="login.jsp">Log
					in</a>
			</div>
			
				<% 
					String emptyFields = request.getParameter("emptyFields");
				
					if(emptyFields == null){
						out.print("");
					} 
					else{
						%><div class="alert alert-danger" role="alert"><% 
						out.print(emptyFields);
						%></div><%
					}
					
				%>
			
		</form>
	
	

	</div>

	
</body>
</html>