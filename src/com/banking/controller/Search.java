package com.banking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.beans.Customer;
import com.banking.services.UserService;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    Customer customer = null;
    UserService service = new UserService();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = (String)request.getParameter("type");
		System.out.println(type);
		String action = request.getParameter("action");
		System.out.println(action);
			
		try {
			
			if(action.equalsIgnoreCase("update")) 
			{
			if(type.equalsIgnoreCase("SSNID"))
			{
			
			String SSNID = (String)request.getParameter("ID");
			System.out.println(SSNID);
			customer = service.searchCustomerBasedOnSSN(SSNID);
			System.out.println(customer);
			if(customer!=null)
			{
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/edit_cust.jsp").include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("message", "requested customer not their in our database");
			    rd.forward(request, response);
			}

			
			}
			
			else
			{
				String CustomerId = (String)request.getParameter("ID");
				request.setAttribute("customer", customer);
				System.out.println(CustomerId);
				
				customer = service.searchCustomerBasedOnCustomerId(CustomerId);
				
				if(customer!=null)
				{
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/edit_cust.jsp").include(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					request.setAttribute("message", "requested customer not their in our database");
				    rd.forward(request, response);
				}
//				request.getRequestDispatcher("/edit_cust.jsp").include(request, response);
			}
			
			}
			
			if(action.equalsIgnoreCase("delete"))
			{
				if(type.equalsIgnoreCase("SSNID"))
				{
				
				String SSNID = (String)request.getParameter("ID");
				System.out.println(SSNID);
				customer = service.searchCustomerBasedOnSSN(SSNID);
				System.out.println(customer);
				if(customer!=null)
				{
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/del_cust.jsp").include(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					request.setAttribute("message", "requested customer not their in our database");
				    rd.forward(request, response);
				}
				
				}
				
				else
				{
					String CustomerId = (String)request.getParameter("ID");
					request.setAttribute("customer", customer);
					System.out.println(CustomerId);
					
					customer = service.searchCustomerBasedOnCustomerId(CustomerId);
					if(customer!=null)
					{
					request.setAttribute("customer", customer);
					request.getRequestDispatcher("/del_cust.jsp").include(request, response);
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						request.setAttribute("message", "requested customer not their in our database");
					    rd.forward(request, response);
					}				
					
				}

			}
		
	
		} 
		catch (NullPointerException e) {
			
			response.sendRedirect("home.jsp");
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
		
		
		
//		try {
//			
//			if(customer!=null)
//			{
//				request.setAttribute("customer", customer);
//
//				String action = request.getParameter("action");
//				if(action.equalsIgnoreCase("update")) {
//					RequestDispatcher rd = request.getRequestDispatcher("edit_cust.jsp");
//					rd.forward(request, response);					
//				}
//				if(action.equalsIgnoreCase("delete")) {
//					RequestDispatcher rd = request.getRequestDispatcher("del_cust.jsp");
//					rd.forward(request, response);					
//				}
//			}
//			else
//			{
//				RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
//				request.setAttribute("message", "requested customer not their in our database");
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = (String)request.getParameter("type");
		System.out.println(type);
		String action = request.getParameter("action");
		System.out.println(action);
			
		try {
			
			if(action.equalsIgnoreCase("update")) 
			{
			if(type.equalsIgnoreCase("SSNID"))
			{
			
			String SSNID = (String)request.getParameter("ID");
			System.out.println(SSNID);
			customer = service.searchCustomerBasedOnSSN(SSNID);
			System.out.println(customer);
			if(customer!=null)
			{
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/edit_cust.jsp").include(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				request.setAttribute("message", "requested customer not their in our database");
			    rd.forward(request, response);
			}

			
			}
			
			else
			{
				String CustomerId = (String)request.getParameter("ID");
				request.setAttribute("customer", customer);
				System.out.println(CustomerId);
				
				customer = service.searchCustomerBasedOnCustomerId(CustomerId);
				
				if(customer!=null)
				{
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/edit_cust.jsp").include(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					request.setAttribute("message", "requested customer not their in our database");
				    rd.forward(request, response);
				}
//				request.getRequestDispatcher("/edit_cust.jsp").include(request, response);
			}
			
			}
			
			if(action.equalsIgnoreCase("delete"))
			{
				if(type.equalsIgnoreCase("SSNID"))
				{
				
				String SSNID = (String)request.getParameter("ID");
				System.out.println(SSNID);
				customer = service.searchCustomerBasedOnSSN(SSNID);
				System.out.println(customer);
				if(customer!=null)
				{
				request.setAttribute("customer", customer);
				request.getRequestDispatcher("/del_cust.jsp").include(request, response);
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
					request.setAttribute("message", "requested customer not their in our database");
				    rd.forward(request, response);
				}
				
				}
				
				
				else
				{
					String CustomerId = (String)request.getParameter("ID");
					request.setAttribute("customer", customer);
					System.out.println(CustomerId);
					
					customer = service.searchCustomerBasedOnCustomerId(CustomerId);
					if(customer!=null)
					{
					request.setAttribute("customer", customer);
					request.getRequestDispatcher("/del_cust.jsp").include(request, response);
					}
					else
					{
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						request.setAttribute("message", "requested customer not their in our database");
					    rd.forward(request, response);
					}				
					
				}

			}
		
	
		} 
		catch (NullPointerException e) {
			
			response.sendRedirect("home.jsp");
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
