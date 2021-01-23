package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDatabase {
	
	
	
	public  boolean validateUser(LoginBean user) throws Exception {
		
		boolean status = false;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		
		
		try {
			Class.forName(driver);
			
			//1. Connect to the database
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","Sangabo1");
			//2. sql Query
			String sql = "SELECT * FROM EMPLOYEE WHERE email=? AND password=?";
			//3. Prepared statement
			PreparedStatement ps = con.prepareStatement(sql);
			//4. Set parameters 
			ps.setString(1, user.getEmail());
			ps.setString(2,user.getPassword());
			
			ResultSet result = ps.executeQuery();
			
			status = result.next();
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
