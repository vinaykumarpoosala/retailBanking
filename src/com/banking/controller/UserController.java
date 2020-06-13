package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.services.UserService;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public UserController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserService service = new UserService();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if(action.equalsIgnoreCase("login"))
		{
			String userName=request.getParameter("userName");
			String password = request.getParameter("password");
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
						request.setAttribute("userRoles", userRoles);
						RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
					 	rd.forward(request, response);	
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("cashier.jsp");
					 	rd.forward(request, response);
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
	}

}
