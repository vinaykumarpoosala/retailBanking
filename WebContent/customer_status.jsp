<%@page import="com.banking.beans.CustomerStatus"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  
}
</style>
<meta charset="ISO-8859-1">
<title>CustomerStatus</title>
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
	<%@ include file="header.jsp"%>

	<br>
	<div class="container">

		<form action="UserController" method="post">
			<h3>Customer Status</h3>
			<br>
			<table>

				<tr>
					<th class="label">Customer Id</th>
					<th class="label">Customer SSN Id</th>
					<th class="label">Customer Status</th>
					<th class="label">Customer Message</th>
					<th class="label">Customer Last Updated</th>
				</tr>

				<%
					List<CustomerStatus> custStatus = (List<CustomerStatus>) request.getAttribute("listOfCustomerStatus");
				%>

				<%
					for (CustomerStatus cust : custStatus) {
				%>
				<tr>
					<td><%=cust.getCustomerId()%></td>
					<td><%=cust.getSsnid()%></td>
					<td><%=cust.getStatus()%></td>
					<td><%=cust.getMessage()%></td>
					<td><%=cust.getLastUpdated()%></td>
				</tr>

				<%
					}
				%>
				<br>
				
</table>

</form>

</div><br><hr>

<%@ include file="footer.jsp"%>
				
</body>
</html>