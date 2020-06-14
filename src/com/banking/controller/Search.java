package com.banking.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
