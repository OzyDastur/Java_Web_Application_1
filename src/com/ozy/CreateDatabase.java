package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDatabase {
	
private static String driver = "com.mysql.cj.jdbc.Driver";
	
	public static void registerCourse(CreateBean course) throws Exception {
		
		try {
			
			Class.forName(driver);
			//1. Connect 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sangabo1");
			//2. SQL query
			String sql = "INSERT INTO course (course_name,department) VALUES (?,?)";
			//3. Prepare statement
			PreparedStatement ps = con.prepareStatement(sql);
			//4. Set parameter
			ps.setString(1,course.getCourse_name());
			ps.setString(2,course.getDepartment());
			
			//4. Excecute query
			
			ps.executeUpdate();
			
		}
		catch(Exception e){
			throw e;
		}
	}


}
