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
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 

	String email = (String)session.getAttribute("email");
	
	if(email == null){
		response.sendRedirect("login.jsp");
	}

%>
<jsp:include page="header.jsp"/>


<jsp:include page="footer.jsp"/>
</body>
</html>
