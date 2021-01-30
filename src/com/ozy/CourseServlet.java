package com.ozy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
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
			
			String course_id = request.getParameter("course_id");
			String course_name = request.getParameter("course_name");
			String department = request.getParameter("department");
			
			
			CourseBean course = new CourseBean();
			
			course.setCourse_id(course_id);
			course.setCourse_name(course_name);
			course.setDepartment(department);
			
			CourseDatabase.registerCourse(course);
			
			response.sendRedirect("course.jsp?successMessage=Congratulations you've successfully registered for the course!");

			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
