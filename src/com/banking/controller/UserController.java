package com.banking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.beans.Customer;
import com.banking.services.UserService;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	Customer customer = null;
		
	
	private static final long serialVersionUID = 1L;


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
						session.setAttribute("TOKEN",userRoles.get("userId"));
						RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
					 	rd.forward(request, response);	
					}
					else
					{
						session.setAttribute("TOKEN",userRoles.get("userId"));
						RequestDispatcher rd = request.getRequestDispatcher("cashier.jsp");
					 	rd.forward(request, response);
					}
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
		if(action.equalsIgnoreCase("createcustomer"))
		{
			
			String token = (String) session.getAttribute("TOKEN");
			
			
			String customername=request.getParameter("customername");
			
			String ssnid = request.getParameter("ssnid");
			Integer age = Integer.parseInt(request.getParameter("age"));
			String city = request.getParameter("city");

			String state = request.getParameter("state");
			String address=request.getParameter("address");
			
			
			System.out.println(customername);
			System.out.println(ssnid);
			System.out.println(age);
			System.out.println(address);
			System.out.println(state);
			System.out.println(city);
			System.out.println(token);
			Customer newCustomer = new Customer(ssnid, customername, age, address, state, city);
			try 
			{
				
				String customerId = service.addCustomer(newCustomer,token);
				
				if (customerId=="" || customerId.isEmpty())
				{
				System.out.println("Sorry customer not created please try again");
				request.setAttribute("customerId", "Sorry customer not created please try again");
				RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
				rd.forward(request, response);
				}
				else
				{
					System.out.println(customerId);
					request.setAttribute("customerId", customerId);
					RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
					rd.forward(request, response);
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			
		}
		
		//UserController/action=serach?SSNID=value
		
		if(action.equalsIgnoreCase("search"))
		{
			String ssnId = (String)request.getParameter("SSNID");
			String cid = (String)request.getParameter("customer_id");
			Map<String,String> searchCreteria = new HashMap<String, String>();
			searchCreteria.put("SSNID",ssnId);
			searchCreteria.put("customer_id",cid);
			try {
				customer = service.searchCustomer(searchCreteria);
				if(customer!=null)
				{
					request.setAttribute("customer", customer);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}

		
		
	}

	
	
}
