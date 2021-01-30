<jsp:include page="header.jsp"/>
<%
	//The code in this section prevents going back after logout
	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
	
	String email = (String)session.getAttribute("email");
	
	if(email == null){
		response.sendRedirect("login.jsp");
	}
	
%>
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
	
        <form action="CourseServlet" method="POST" class="form">
        
            <div>
                <h3>Manage Your Courses</h3>
           </div>
          <div>
            <label for="course_id" class="course_id">Course id</label><br>
            <input class="form-control" type="text" name="course_id" value=""><br>
        </div> 
               
         <div>
            
            <label for="course_name" class="course_name">Name of the course</label><br>
            <input class="form-control" type="text" name="course_name" value=""><br>
        </div> 
         <div>
            <label for="department" class="department">Department </label><br>
            <input class="form-control" type="text" name="department" value=""><br>
        </div> 
        <div class="form-group"> 
                <input type="submit" name="save" value="Add Course" class="btn btn-success"><br>
                <p><a href="ViewCourseServlet" style="font-size:20px;">View your courses </a></p>
               
        </div>
        </form>
       
    </div>
    
<jsp:include page="footer.jsp"/>
