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
		<p></p>
		<p></p>
		<div><a href="ViewCourseServlet" style="font-size:20px; margin-top:100px;">View your courses</a></div>
		<hr>
        <form action="CourseServlet" method="POST" class="form">
        
            <div>
                <h3>Add a New Course</h3>
           </div>
          <div>
            <label for="course_id" class="course_id">Course id</label><br>
            <input class="form-control" type="text" name="course_id" placeholder="Enter course id"><br>
        </div> 
               
         <div>
            
            <label for="course_name" class="course_name">Name of the course</label><br>
            <input class="form-control" type="text" name="course_name" placeholder="Enter course"><br>
        </div> 
         <div>
            <label for="department" class="department">Department </label><br>
            <input class="form-control" type="text" name="department" value="Enter department"><br>
        </div> 
        <div class="form-group"> 
                <input type="submit" name="save" value="Add Course" class="btn btn-success"><br>
               
               
        </div>
        </form>
       
    </div>
    
<jsp:include page="footer.jsp"/>
