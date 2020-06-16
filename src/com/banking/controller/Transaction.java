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

import com.banking.beans.Account;
import com.banking.beans.Customer;
import com.banking.services.TransactionService;

@WebServlet("/Transaction")
public class Transaction extends HttpServlet {

	Customer customer = null;
	TransactionService service = new TransactionService();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Account> accounts = null;
		String type = (String) request.getParameter("type");
		System.out.println(type);
		String action = request.getParameter("action");
		System.out.println(action);

		

			if (action.equalsIgnoreCase("deposit")) {
				if (type.equalsIgnoreCase("ACCOUNT_ID")) {
					
					String ACCOUNT_ID = request.getParameter("ID");
					System.out.println(ACCOUNT_ID);
					accounts = service.searchAccountBasedOnAccountId(ACCOUNT_ID);
					System.out.println(accounts);
					System.out.println(accounts);
					if (accounts == null || accounts.isEmpty() 	) {
						
						request.setAttribute("message", "requested account not their in our database");
						request.getRequestDispatcher("home.jsp").include(request, response);
						
					} else {
						request.setAttribute("account", accounts);
						request.getRequestDispatcher("/deposit.jsp").include(request, response);
						
					}

				}

				else {
					String CustomerId = (String) request.getParameter("ID");
					System.out.println(CustomerId);
					
					accounts = service.searchAccountBasedOnCustomerId(CustomerId);
					System.out.println(accounts.size());
					System.out.println(accounts);

					if (accounts.size()>1) {
						request.setAttribute("account", CustomerId);
						request.getRequestDispatcher("/transfer.jsp").include(request, response);
					} else {
						
						if (accounts.size()<=1) {
							request.setAttribute("message", "customer doesn't have multiple accounts");
							request.getRequestDispatcher("/home.jsp").include(request, response);
							
						}
						else
						{
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						request.setAttribute("message", "requested customer not their in our database ");
						rd.forward(request, response);
						}
					}
				}

			}
			

			if (action.equalsIgnoreCase("withdraw")) {
				if (type.equalsIgnoreCase("ACCOUNT_ID")) {

					String ACCOUNT_ID = (String) request.getParameter("ID");
					System.out.println(ACCOUNT_ID);
					accounts = service.searchAccountBasedOnAccountId(ACCOUNT_ID);
					System.out.println(accounts);
					if (accounts != null) {
						request.setAttribute("account", accounts);
						request.getRequestDispatcher("/withdraw.jsp").include(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						request.setAttribute("message", "requested account not their in our database");
						rd.forward(request, response);
					}

				}

				else {
					String CustomerId = (String) request.getParameter("ID");
					System.out.println(CustomerId);

					accounts = service.searchAccountBasedOnCustomerId(CustomerId);

					if (accounts != null) {
						request.setAttribute("account", accounts);
						request.getRequestDispatcher("/withdraw.jsp").include(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
						request.setAttribute("message", "requested customer not their in our database");
						rd.forward(request, response);
					}
				}

			}
			
			
						
			

		} 
	

	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = (String) request.getParameter("type");
		System.out.println(type);
		String action = request.getParameter("action");
		System.out.println(action);
		try {
		if (action.equalsIgnoreCase("depositMoney")) 
		{
			String accountId = request.getParameter("accid");
			System.out.println(accountId);
			int depositAmount = Integer.parseInt(request.getParameter("depositAmount"));
			System.out.println(depositAmount);
			String accountType = request.getParameter("acctype");
			boolean isMoneyDeposited = false;
			
				isMoneyDeposited = service.depositMoney(accountId,depositAmount,accountType);
			
			if(!isMoneyDeposited)
			{
				request.setAttribute("message", "moneyDepositedSuccessfully");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			else
			{
				request.setAttribute("message", "money Deposition failed try again");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			
		}
		if (action.equalsIgnoreCase("withdrawMoney")) 
		{
			String accountId = request.getParameter("accid");
			System.out.println(accountId);
			int depositAmount = Integer.parseInt(request.getParameter("depositAmount"));
			System.out.println(depositAmount);
			String accountType = request.getParameter("acctype");
			boolean isMoneyDeposited = false;
			
				isMoneyDeposited = service.withdrawMoney(accountId,depositAmount,accountType);
			
			if(!isMoneyDeposited)
			{
				request.setAttribute("message", "money withdraw Successfully completed");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			else
			{
				request.setAttribute("message", "money withdraw failed, please try again");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			
		}
		
		if (action.equalsIgnoreCase("transfer")) 
		{
			String customerId = request.getParameter("customer_id");
			System.out.println("customer id "+customerId);
			int transferAmount = Integer.parseInt(request.getParameter("amount"));
			System.out.println(transferAmount);
			String sourceAccountType = request.getParameter("sourceacctype");
			System.out.println(sourceAccountType);
			String targetaccountType = request.getParameter("targetacctype");
			System.out.println(targetaccountType);

			boolean isMoneyTransfered = false;
			
			isMoneyTransfered = service.transferMoney(customerId,sourceAccountType,targetaccountType,transferAmount);
			
			if(!isMoneyTransfered)
			{
				request.setAttribute("message", "money transferd Successfully completed");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			else
			{
				request.setAttribute("message", "money transfer failed, please try again");
				request.getRequestDispatcher("/home.jsp").include(request, response);
			}
			
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
}
}
