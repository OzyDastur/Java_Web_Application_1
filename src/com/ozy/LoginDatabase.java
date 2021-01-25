package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.tomcat.util.codec.binary.Base64;

public class LoginDatabase {
		
	public  boolean validateUser(LoginBean user) throws Exception {
		
		boolean status = false;
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		
		
		try {
			Class.forName(driver);
			
			//1. Connect to the database
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","Sangabo1");
			//2. sql Query
			
			
			String sql = "SELECT * FROM EMPLOYEE WHERE email=? ";
			//3. Prepared statement
			PreparedStatement ps = con.prepareStatement(sql);
			//4. Set parameters 
			ps.setString(1, user.getEmail());
			
			String pw = "SELECT password FROM EMPLOYEE WHERE email = user.getEmail()";
			
			
			//Decoding password and then checking
			byte[] decodePw = Base64.decodeBase64(pw);
			String pwDecode = new String(decodePw);
			
			//Compare the two passwords and check the email in the database
			if(pwDecode.equals(user.getPassword())) {
				ResultSet result = ps.executeQuery();
				
				status = result.next();
				
			}
			
			
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
