package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseConnection {
	private static String driver = "com.mysql.cj.jdbc.Driver";
	
	public static void registerUser(User user) throws Exception {
		
		try {
			
			Class.forName(driver);
			//1. Connect 
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","Sangabo1");
			//2. SQL query
			String sql = "INSERT INTO employee (username,email,gender,password, confirm_password) VALUES (?,?,?,?,?)";
			//3. Prepare statement
			PreparedStatement ps = con.prepareStatement(sql);
			//4. Set parameter
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getConfirm_password());
			
			//4. Excecute query
			
			ps.executeUpdate();
			
		}
		catch(Exception e){
			throw e;
		}
	}

}
