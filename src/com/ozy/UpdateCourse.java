package com.ozy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateCourse
 */
@WebServlet("/UpdateCourse")
public class UpdateCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			//This line is very important for external browser to recognize the file 
			response.setContentType("text/html");
			String driver = "com.mysql.cj.jdbc.Driver";
			Class.forName(driver);
			PrintWriter out = response.getWriter();
			
			//Receive data from the edit form
			String course_id = request.getParameter("course_id");
			String course_name = request.getParameter("course_name");
			String department = request.getParameter("department");
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sangabo1");
			
			String sql = "UPDATE course SET course_name=?, department=? WHERE course_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, course_name);
			ps.setString(2, department);
			ps.setString(3, course_id);
			
			ps.executeUpdate();
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
