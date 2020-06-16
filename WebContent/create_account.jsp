<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
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

	<form action="AccountController" method="post">
	<h3>Create Account</h3><br>
		<table>

				<tr>
					<th class="label">Customer ID</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="customerid" type="text" placeholder="Enter Customer ID"
						required></td>
				</tr>

				<tr>
					<th class="label">Account Type</th><td>:</td>
					<td class="value"><select id="acctype" class="form-control"
						name="acctype" required>
						<option value="Select">---Select---</option>
						<option value="Savings">Savings</option>
  						<option value="Current">Current</option>
						</select></td>
				</tr>
				
				<tr>
					<th class="label">Deposit</th><td>:</td>
					<td class="value"><input class="form-control" id="deposit"
						name="deposit" type="number" required>
						<input type="hidden" name="action" value="createAccount"></td>
				</tr>
				
		</table>
		<br>
		<div>
				<input type="submit" class="btn btn-success">
		</div>
		<br>
	</form>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>