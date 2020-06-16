<%@page import="com.banking.beans.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Deposit</title>
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
<% if(session.getAttribute("TOKEN")==null || session.getAttribute("TOKEN")=="")
{
	response.sendRedirect("login.jsp");
}
response.setHeader("Cache-Control","no-cache , no-store,must-revalidate");%>
<% String userType = (String)session.getAttribute("USER_TYPE"); %>
<input type="hidden" id="user_Type" value="<%= userType %>">
<%@ include file="header.jsp" %>

	<br>
	<div class="container">

	<form action="Transaction" method="post">
	<input type="hidden" name="action" value="depositMoney">
	<h3>Deposit Money</h3><br>
	
	<% List<Account> accounts = (List)request.getAttribute("account"); %>
	
	<table>
	<% for(Account acc : accounts) { %>
		

				<tr>
					<th class="label">Customer ID</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="userid" type="text" readonly value="<%=acc.getCustomerId() %>" placeholder="<%= acc.getCustomerId() %>"
						required></td>
				</tr>
				
				<tr>
					<th class="label">Account ID</th><td>:</td>
					<td class="value"><input class="form-control" id="accid"
						name="accid" type="text" readonly value="<%=acc.getAccountId() %>" placeholder="<%= acc.getAccountId() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">Account Type</th><td>:</td>
					<td class="value"><input class="form-control" id="acctype"
						name="acctype" type="text" readonly  value="<%=acc.getAccountType() %>" placeholder="<%= acc.getAccountType() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">Balance</th><td>:</td>
					<td class="value"><input class="form-control" id="bal"
						name="bal" readonly value="<%=acc.getBalance() %>" placeholder="<%= acc.getBalance() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">Deposit Amount</th><td>:</td>
					<td class="value"><input class="form-control" id="deposit"
						name="depositAmount" type="number"  placeholder="Enter Amount" required></td>
				</tr>
		
		<% } %>		
		</table>
		<br>
		<div>
				<input type="submit" class="btn btn-success"  value="deposit" >
		</div>
		<br>
	</form>
	</div>
	
<%@ include file="footer.jsp" %>

</body>
</html>