package com.ozy.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ozy.model.User;

public class UserDao {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private String jdbcURL = "jdbc:mysql://localhost:3306/crud";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Sangabo1";

	private static final String INSERT_USERS_SQL = "INSERT INTO users (name, email, country) VALUES  (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User user)  {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			
			ps.executeUpdate();
		} 
		catch (Exception e) {
			e.printStackTrace();;
		}
	}

	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try {
			Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet rs = ps.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(id, name, email, country);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();;
		}
		return user;
	}

	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				users.add(new User(id, name, email, country));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();;
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(DELETE_USERS_SQL);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		}
		catch (Exception e) {
			e.printStackTrace();;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try {
			Connection connection = getConnection();
			PreparedStatement ps = connection.prepareStatement(UPDATE_USERS_SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.setInt(4, user.getId());

			rowUpdated = ps.executeUpdate() > 0;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}
	


}
