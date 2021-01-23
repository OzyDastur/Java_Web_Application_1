package com.ozy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//Recieving request from client/user
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			String confirm_password = request.getParameter("confirm_password");
			
			
			
			
			//Create an object of the User class
			User user = new User ();
			
			user.setUsername(username);
			user.setEmail(email);
			user.setGender(gender);
			user.setPassword(password);
			user.setConfirm_password(confirm_password);
			
			
			//Call database class and pass user data
			DatabaseConnection.registerUser(user);
			//redirect
			response.sendRedirect("login.jsp");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
