package com.ozy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCourse
 */
@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
		try {
			//This line is very important for external browser to recognize the file 
			response.setContentType("text/html");
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			PrintWriter out = response.getWriter();
			String course_id = request.getParameter("course_id");
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sangabo1");
			
			//Retrieve email from database
			String sql = "SELECT * FROM course WHERE course_id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				
				out.println("<form action='UpdateCourse' method='POST'>");
				
					out.println("<label> Course ID </label>");
					out.println("<input type='text' name='course_id' value='" + rs.getString("course_id")+"'>");
					out.println("<label > Course Name</label>");
					out.println("<input type='text' name='course_name' value='" + rs.getString("course_name")+"'>");
					out.println("<label > Department </label>");
					out.println("<input type='text' name='department' value='" + rs.getString("department")+"'>");
					out.println("<input type='submit' value='Update Course'/>");
				
				out.print("</form>");
			}
			

			
		}
		catch(Exception e) {
			
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
