package com.banking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.services.UserService;



//import com.banking.services.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
		UserService service = new UserService();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action.equalsIgnoreCase("login"))
		{
			
			String userName=request.getParameter("userName");
			String password = request.getParameter("password");
			if(userName!=null || password !=null ) 
			{
			try {
				Map<String,String> userRoles = service.validate(userName, password);
				System.out.println(userRoles);
				
				if(userRoles==null || userRoles.isEmpty())
				{
					System.out.println("in if condition");
					request.setAttribute("message","invalid credentials");
					request.getRequestDispatcher("login.jsp").include(request, response);

				}
				
				else
				{
					if(userRoles.get("userRole").equalsIgnoreCase("EXCECUTIVE"))
					{
						//random number base64 shaw256
						
						session.setAttribute("TOKEN",userRoles.get("userId"));
						session.setMaxInactiveInterval(1200);
						session.setAttribute("USER_TYPE", "EXCECUTIVE");
						response.sendRedirect("UserController?login=success&role=executive&action=success");
					 		
					 	


					}
					else
					{
						session.setAttribute("USER_TYPE", "CASHIER");
						session.setMaxInactiveInterval(1200);
						session.setAttribute("TOKEN",userRoles.get("userId"));
						response.sendRedirect("UserController?login=success&role=cashier&action=success");
					 	
					}
					
				}
			}
			 catch (SQLException e) {
				e.printStackTrace();
			}
			}
			
							
			
		}

	}

}
