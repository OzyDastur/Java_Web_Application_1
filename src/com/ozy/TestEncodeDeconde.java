package com.ozy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.util.codec.binary.Base64;


public class TestEncodeDeconde {

	public static void main(String[] args) throws SQLException {
		
		
		
		//1. Connect to the database
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","Sangabo1");
		
		String email = "cat@gmail.com";
		
		//Retrieve email from database
		String sql = "SELECT * FROM EMPLOYEE WHERE email=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		
		String pw = "";
		while(rs.next()) {
			pw = rs.getString("password");
			
		}
		
		byte [] pwByte = pw.getBytes();
		byte [] decodePw = Base64.decodeBase64(pwByte );
		String pwDecoded = new String(decodePw);
		
		
		System.out.print(pwDecoded);
		
		
	
	}

	

}
