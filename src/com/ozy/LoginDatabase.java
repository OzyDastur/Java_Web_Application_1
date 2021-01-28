package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.tomcat.util.codec.binary.Base64;

public class LoginDatabase {

	
	private String driver = "com.mysql.cj.jdbc.Driver";

		

	public  boolean validateUser(LoginBean user) throws Exception {
		
		boolean status = false;
		
		try {
			Class.forName(driver);
			
			//1. Connect to the database
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Sangabo1");

			
			//Retrieve email from database
			String sql = "SELECT * FROM student WHERE email=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();
			
			String password = "";
			while(rs.next()) {
				password = rs.getString("password");
				
			}
			
			byte [] pwByte = password.getBytes();
			byte [] decodePw = Base64.decodeBase64(pwByte );
			String pwDecoded = new String(decodePw);
			
			
			//Compare the two passwords and check the email in the database
	
			if(user.getPassword().equals(pwDecoded)) {
			
				status = true;
			
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		

		return status;
		
		
	}

	
}
