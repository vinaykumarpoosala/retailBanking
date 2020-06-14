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
<%@ include file="header.jsp" %>

	<br>
	<div class="container">

	<form action="UserController" method="post">
	<h3>Delete Customer</h3><br>
		<table>

				<tr>
					<th class="label">Customer SSN Id</th><td>:</td>
					<td class="value"><input class="form-control" id="snnid"
						name="ssnid" type="text" value=""
						required></td>
				</tr>

				<tr>
					<th class="label">Customer Id</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="customerid" type="text" value="db.getUserid() %>"
						required></td>
				</tr>
				
				<tr>
					<th class="label">Customer Name</th><td>:</td>
					<td class="value"><input class="form-control" id="customername"
						name="customername" type="text" value="db.getUsername() %>" ></td>
				</tr>
				
								
				<tr>
					<th class="label">Age</th><td>:</td>
					<td class="value"><input class="form-control" id="age"
						name="age" value="db.getUserage() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">Customer Address</th><td>:</td>
					<td class="value"><input class="form-control" id="customeraddr"
						name="customeraddr" type="text" value="db.getUseraddr() %>" ></td>
				</tr>
				
		</table>
		<br>
		<div>
				<button type="button" class="btn btn-danger">Confirm Delete</button>
				<button type="button" class="btn btn-info">Cancel</button>
		</div>
		<br>
	</form>
	</div>


<%@ include file="footer.jsp" %>
</body>
</html>