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
<jsp:include page="header.jsp"/>
	<h1 style="text-align:center;"> Welcome to employee table</h1>
	
	 <div class="left">
        <form action="CreateOrUpdateServlet.jsp" method="POST" >
        <div class="form-group">
            <div>
                <h3>CRUD Form </h3>
               
            </div>
            <input  type="hidden" name="id" value="">
            <label for="name" class="name">Name</label><br>
            <input class="form-control" type="text" name="name" value=""><br>
        </div> 
        <div class="form-group">
            <label for="location" class="location">Location</label><br>
        
          
            <input class="form-control" type="text" name="location" value=""><br>
        </div>  
        <div class="form-group"> 
           
         
                <input type="submit" name="save" value="Save" class="btn btn-success">  </button>
                
          
                <input type="submit" name="update" value="Update" class="btn btn-primary"></button>
           
        </div>
        </form>
        </div>
<jsp:include page="footer.jsp"/>
</body>
</html>