<%@page import="com.banking.beans.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete customer</title>
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
	
	
	<form action="UserController" method="post">
	<h3>Delete Customer</h3><br>
	<% Customer cust = (Customer)request.getAttribute("customer");%>
		<table>

				<tr>
					<th class="label">Customer SSN Id</th><td>:</td>
					<td class="value"><input class="form-control" id="snnid"
						name="ssnid" type="text" value="<%=cust.getSsnid() %>"
						readonly="readonly" required></td>
				</tr>

				<tr>
					<th class="label">Customer Id</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="customerid" type="text" value="<%=cust.getCustomerId() %>"
						readonly="readonly" required></td>
				</tr>
				
				<tr>
					<th class="label">Customer Name</th><td>:</td>
					<td class="value"><input class="form-control" id="customername"
						name="customername" type="text" value="<%=cust.getCustomername() %>" readonly="readonly"></td>
				</tr>
				
								
				<tr>
					<th class="label">Age</th><td>:</td>
					<td class="value"><input class="form-control" id="age"
						name="age" value="<%=cust.getAge() %>" readonly="readonly"></td>
				</tr>
				
				<tr>
					<th class="label">Customer Address</th><td>:</td>
					<td class="value"><input class="form-control" id="customeraddr"
						name="customeraddr" type="text" value="<%=cust.getAddress() %>" readonly="readonly"></td>
				</tr>
				
		</table>
		<br>
		<div>
				<input type="submit"  class="btn btn-danger" value="Confirm Delete">
				<input type="hidden" name="customerId" value="<%=cust.getCustomerId()%>">
				<input type="hidden" name="action" value="delete">
				
				<button type="button" class="btn btn-info">Cancel</button>
		</div>
		<br>
	</form>
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>