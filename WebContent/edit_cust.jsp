<%@page import="com.banking.beans.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit customer</title>
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
	<% Customer cust = (Customer)request.getAttribute("customer");%>

	<form action="UserController" method="post">
	<h3>Update customer</h3><br>
		<table>
				
				<tr>
					<th class="label">Customer SSN Id</th><td>:</td>
					<td class="value"><input class="form-control" id="snnid"
						name="ssnid" type="text" value="<%=cust.getSsnid() %>"
						required readonly="readonly"></td>
				</tr>

				<tr>
					<th class="label">Customer Id</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="userid" type="text" value="<%=cust.getCustomerId() %>"
						required readonly="readonly"></td>
				</tr>
				
				<tr>
					<th class="label">Old Customer Name</th><td>:</td>
					<td class="value"><input class="form-control" id="customername"
						name="customernameoldname" type="text" value="<%=cust.getCustomername() %>"  readonly="readonly"></td>
				</tr>
				
				<tr>
					<th class="label">New Customer Name</th><td>:</td>
					<td class="value"><input class="form-control" id="customername"
						name="customername" type="text" required ></td>
				</tr>

				<tr>
					<th class="label">Old Customer Address</th><td>:</td>
					<td class="value"><input class="form-control" id="customeraddr"
						name="customername" type="text" value="<%=cust.getAddress() %>" readonly="readonly"></td>
				</tr>
				
				<tr>
					<th class="label">New Customer Address</th><td>:</td>
					<td class="value"><input class="form-control" id="address"
						name="address" type="text" required></td>
				</tr>
				
				<tr>
					<th class="label">Old Age</th><td>:</td>
					<td class="value"><input class="form-control" id="oldage"
						name="oldage" value="<%=cust.getAge() %>" readonly="readonly"></td>
				</tr>
				
				<tr>
					<th class="label">New Age</th><td>:</td>
					<td class="value"><input class="form-control" id="newage"
						name="age" type="number" required></td>
				</tr>
				
		</table>
		<br>
		<div>
				<input type="submit" class="btn btn-success" value="Update">
				<input type="hidden" name="customerId" value="<%=cust.getCustomerId()%>">
				<input type="hidden" name="action" value="update">
				
		</div>
		<br>
	</form>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>