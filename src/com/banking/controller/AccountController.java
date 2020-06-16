package com.banking.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.banking.beans.Account;
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//createCustomer
		UserService service = new UserService();

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
