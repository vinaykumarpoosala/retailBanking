<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer</title>
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
<%@ include file="header.jsp" %>
<% if(session.getAttribute("TOKEN")==null || session.getAttribute("TOKEN")=="")
{
	response.sendRedirect("login.jsp");
}
response.setHeader("Cache-Control","no-cache , no-store,must-revalidate");%>
<% String userType = (String)session.getAttribute("USER_TYPE"); %>
<input type="hidden" id="user_Type" value="<%= userType %>">


	<br>
	<div class="container">

	<form action="Transaction" method="post">
	<input type="hidden" name="action" value="transfer">
	
	<h3>Transfer Account</h3><br>
		<table>
				<% String customerId = (String)request.getAttribute("account"); %>
				<tr>
					<th class="label">Customer ID</th><td>:</td>
					<td class="value"><input class="form-control" id="accid"
						name="id" type="text" readonly value ="<%= customerId%>"placeholder="<%= customerId%>" ></td>
				</tr>
				
				<tr>
					<th class="label">Source Account Type</th><td>:</td>
					<td class="value"><select id="acctype" class="form-control"
						name="sourceacctype" required>
						<option value="Select">---Select---</option>
						<option value="Savings">Savings</option>
  						<option value="Current">Current</option>
						</select></td>
				</tr>
							
				<tr>
					<th class="label">Target Account Type</th><td>:</td>
					<td class="value"><select id="acctype" class="form-control"
						name="targetacctype" required>
						<option value="Select">---Select---</option>
						<option value="Savings">Savings</option>
  						<option value="Current">Current</option>
						</select></td>
				</tr>
				<tr>
					<th class="label">Transfer amount</th><td>:</td>
					<td class="value"><input type ="text" name = "amount">
						</td>
				</tr>
				
		</table>
		<br>
		<div>
		<input type="hidden" name = "customer_id" value="<%= customerId%>">
				<input type="submit" class="btn btn-success"  value="transfer" >
		</div>
		<br>
	</form>
	</div>
	
<%@ include file="footer.jsp" %>

</body>
</html>