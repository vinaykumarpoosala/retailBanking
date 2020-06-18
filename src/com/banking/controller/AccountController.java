package com.banking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.banking.beans.Account;
import com.banking.beans.AccountStatus;
import com.banking.beans.CustomerStatus;
import com.banking.services.UserService;


@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();

		String action = request.getParameter("action");
		
		if(action.equalsIgnoreCase("AccountToDelete"))
		{
			List<String> listOfAccountIds  = service.fetchAllCustomerIds();
			if(listOfAccountIds!=null || !listOfAccountIds.isEmpty())
			{
				request.setAttribute("listOfAccountIds", listOfAccountIds);
				request.getRequestDispatcher("/del_acc.jsp").include(request, response);
			}
		}
		
		if(action.equalsIgnoreCase("accountstatement"))
		{
			
		
			List<AccountStatus> ListOfAccoujntStatus = service.findaccountStatus();
			
			if(ListOfAccoujntStatus!=null || ListOfAccoujntStatus.size()>0)
			{
				
				request.setAttribute("ListOfAccountStatus", ListOfAccoujntStatus);
				RequestDispatcher rd = request.getRequestDispatcher("account_status.jsp");
				rd.forward(request, response);
				System.out.println("customers found");
				//response.sendRedirect("executive.jsp");
			}
			else
			{
				request.setAttribute("message", "No customers found");
				RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
				rd.forward(request, response);
			}
		}
		
		
		if(action.equalsIgnoreCase("accountstatus"))
		{
			
		
			List<AccountStatus> ListOfAccoujntStatus = service.findaccountStatus();
			
			if(ListOfAccoujntStatus!=null || ListOfAccoujntStatus.size()>0)
			{
				
				request.setAttribute("ListOfAccountStatus", ListOfAccoujntStatus);
				RequestDispatcher rd = request.getRequestDispatcher("account_status.jsp");
				rd.forward(request, response);
				System.out.println("customers found");
				//response.sendRedirect("executive.jsp");
			}
			else
			{
				request.setAttribute("message", "No customers found");
				RequestDispatcher rd = request.getRequestDispatcher("executive.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//createCustomer
		UserService service = new UserService();
		HttpSession session = request.getSession();
		if(session.getAttribute("TOKEN")==null || session.getAttribute("TOKEN")=="")
		{
			response.sendRedirect("login.jsp");
		}
		response.setHeader("Cache-Control","no-cache , no-store,must-revalidate");

		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("createAccount"))
		{
			String customerId = request.getParameter("customerid");
			String accountType = request.getParameter("acctype");
			int deposit = Integer.parseInt(request.getParameter("deposit"));
			/*
			 * 
			 * String customerId;
	String accountId;
	String accountType;
	int deposit;
			 */

			String accountId = service.addAccount(new Account(customerId,accountType,deposit));
			System.out.println(accountId);
			if (accountId=="" || accountId.isEmpty())
			{
			System.out.println("Sorry account not created please try again with different account type | customer");
			request.setAttribute("message", "Sorry account not created please try again with different account type | customer");
			request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			else
			{
				System.out.println(accountId);
				request.setAttribute("message", "account created with accountId : "+accountId);
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			
		}
		
		
		if(action.equalsIgnoreCase("delete"))
		{
			String account_id = request.getParameter("account_id");
			String account_type = request.getParameter("account_type");
			System.out.println(account_id);
			System.out.println(account_type);
			
			boolean accountDeleted = service.deleteAccount(account_id,account_type);
			if(!accountDeleted)
			{
				request.setAttribute("message", "account deleted successfully");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			else
			{
				request.setAttribute("message", "account doesnot exists with specified account type");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			System.out.println(account_type+" "+account_id);
		}
		
		 
		
	

	}

}
