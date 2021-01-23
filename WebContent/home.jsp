<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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


<h1 style="text-align:center;"> Welcome home </h1>
	<!-- String email = (String)session.getAttribute("email");
	
	if(email == null){
		response.sendRedirect("login.jsp");
	} -->
	<p> Please click here to logout</p><a href="http://localhost:8080/registration/logout.jsp">Logout</a>
</body>
</body>
</html>

