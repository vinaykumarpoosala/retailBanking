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

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
					
					response.sendRedirect("login.jsp");
				}
				
				else
				{
					if(userRoles.get("userRole").equalsIgnoreCase("EXCECUTIVE"))
					{
						session.setAttribute("TOKEN",userRoles.get("userId"));
						session.setAttribute("USER_TYPE", "EXCECUTIVE");
						response.sendRedirect("UserController?login=success&role=executive&action=success");
					 		
					 	


					}
					else
					{
						session.setAttribute("USER_TYPE", "CASHIER");
						session.setAttribute("TOKEN",userRoles.get("userId"));
						response.sendRedirect("UserController?login=success&role=cashier&action=success");
					 	
					}
					
				}
			}
			 catch (SQLException e) {
				e.printStackTrace();
			}
			}
			else
				request.setAttribute("message","invalid credentials");
			
			
		}

	}

}
