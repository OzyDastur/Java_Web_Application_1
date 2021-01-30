package com.ozy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewCourseServlet
 */
@WebServlet("/ViewCourseServlet")
public class ViewCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			PrintWriter out = response.getWriter();
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sangabo1");
			
			String sql = "SELECT * FROM course";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<table border='1px solid black' cellspacing='0' width='100%'  border-collapse='collapse'>");
			out.println("<tr>");
			    out.println("<th>Course ID</th>");
			    out.println("<th>Course Name</th>");
			    out.println("<th>Department</th>");
			    out.println("<th>Edit</th>");
			    out.println("<th>Drop</th>");
		  out.println("</tr>");
			
			while(rs.next()) {
				
				String course_id = rs.getString("course_id");
				String course_name = rs.getString("course_name");
				String department = rs.getString("department");
				
				out.println("<tr>");
					out.println("<td>"+ course_id + "</td>");
					out.println("<td>"+ course_name +"</td>");
					out.println("<td>"+ department +"</td>");
					out.println("<td>"+ "<a href='EditCourse?course_id="+ course_id + "'>Edit </a>"+"</td>");
					out.println("<td>"+ "<a href='DeleteCourse?course_id="+ course_id + "'>Drop </a>"+"</td>");
					
				
				out.println("</tr");
				
			
			}
			out.println("</table>");
		
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
