<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Account</title>
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>
<% if(session.getAttribute("TOKEN")==null || session.getAttribute("TOKEN")=="")
{
	response.sendRedirect("login.jsp");
}
response.setHeader("Cache-Control","no-cache , no-store,must-revalidate");%>
<% String userType = (String)session.getAttribute("USER_TYPE"); %>

<%@ include file="header.jsp" %>

	<br>
	<div class="container">

	<form action="AccountController?action=delete" method="post">
	<h3>Delete Account</h3><br>
		<table>

				<tr>
					<th class="label">Account ID</th><td>:</td>
					<td class="value"><select id="acc_id" class="form-control"
						name="account_id" >
						<option value="Select" >---Select---</option>
						<% List<String> listOfAccounts =(ArrayList<String>) request.getAttribute("listOfAccountIds"); %>
						<% for(String id : listOfAccounts ) {  %>
						<option value="<%=id %>"><%=id %></option>
						<% } %>
					</td>
				</tr>

		<tr>
					<th class="label">Account Type</th><td>:</td>
					<td class="value"><input class="form-control" id="account_type"
						name="account_type"  placeholder="Account type" ></td>
				</tr>
				
		</table>
		<br>
		<div>
				<input type="submit" class="btn btn-danger">
		</div>
		<br>
	</form>
	</div>

<%@ include file="footer.jsp" %>
		
</body>
</html>