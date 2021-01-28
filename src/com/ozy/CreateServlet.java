package com.ozy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String course_name = request.getParameter("course_name");
			String department = request.getParameter("department");
			
			
			//Create a bean or Model or a Pojo object
			CreateBean course = new CreateBean();
			
			//Set course name and department
			course.setCourse_name(course_name);
			course.setDepartment(department);
			
			//Call course database and pass course object
			CreateDatabase.registerCourse(course);
			
			response.sendRedirect("course.jsp?successMessage=Congratulations you've successfully registered the course! ");

			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
