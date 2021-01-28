package com.ozy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
try {
			
			//Recieving request from client/user
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String gender = request.getParameter("gender");
			String password = request.getParameter("password");
			String confirm_password = request.getParameter("confirm_password");
			
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		    
			
			
		
			if(username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm_password.isEmpty()) {
				response.sendRedirect("signup.jsp?emptyFields=Please complete all the fields");
			}
			else if(!email.matches(regex)){
				response.sendRedirect("signup.jsp?invalidEmail=Invalid email");
			}
			else if(!password.equals(confirm_password)) {
				
				response.sendRedirect("signup.jsp?passwordMismatch=The two passwords do not match");
			}
			else if(!password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
				response.sendRedirect("signup.jsp?invalidPassword=Password must be at least 8 characters one uppercase one lowercase one number one special character");
			}
		
		
			else {
				
				//Encode password 
				byte[] encodePw = Base64.encodeBase64(password.getBytes());
				String pwEncode = new String(encodePw);
				
				//Encode confirm password
				byte[] encodeCpw = Base64.encodeBase64(password.getBytes());
				String pwConfirmEncode = new String(encodeCpw);
				
		
				//Create an object of the User class
				SignupBean user = new SignupBean ();
				
				user.setUsername(username);
				user.setEmail(email);
				user.setGender(gender);
				user.setPassword(pwEncode);
				user.setConfirm_password(pwConfirmEncode);
				
			
				
				//Call database class and pass user data
				SignupDatabase.registerUser(user);
				//redirect
				response.sendRedirect("login.jsp?successMessage=Congratulations you've successfully registered! Please log in with your email and password");
		
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
