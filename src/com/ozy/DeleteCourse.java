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
 * Servlet implementation class DeleteCourse
 */
@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCourse() {
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
			
			String sql = "DELETE FROM course WHERE course_id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, course_id);
			ps.executeUpdate();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
