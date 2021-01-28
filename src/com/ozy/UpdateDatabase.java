package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDatabase {
	
private static String driver = "com.mysql.cj.jdbc.Driver";
	
	public static void updateCourse(UpdateBean course) throws Exception {
		
		try {
			
			Class.forName(driver);
			//1. Connect 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sangabo1");
			String sql = "SELECT * FROM course";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			int id = 0;
			while(rs.next()) {
				id = rs.getInt(id);
			}
			
			String update = "UPDATE course SET course_name='course.getCourse_name()', department='course.getDepartment()' WHERE id =id";
		   
		}
		catch(Exception e){
			throw e;
		}
	}


}
