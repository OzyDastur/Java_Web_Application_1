package com.ozy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
			
			
			
			if(email.isEmpty() || password.isEmpty()) {
				response.sendRedirect("login.jsp?emptyFields=Please complete all the fields");
			}
			else if(!email.matches(regex)){
				response.sendRedirect("login.jsp?invalidEmail=Invalid email");
			}
			else {
				
				LoginBean user = new LoginBean();
				
				user.setEmail(email);
				user.setPassword(password);
				LoginDatabase DB = new LoginDatabase();
				
				
				
				boolean result = DB.validateUser(user);
				 
				
				if(result == true) {
	
					HttpSession session = request.getSession();
					session.setAttribute("email", user.getEmail());
					response.sendRedirect("index.jsp");
				}
				else {
					response.sendRedirect("login.jsp?incorrectEmailOrPassword=Incorrect email or password");				
					}
			
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
