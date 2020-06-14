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

	<br>
	<div class="container">

	<form action="UserController" method="post">
	<h3>Update customer</h3><br>
		<table>

				<tr>
					<th class="label">Customer SSN Id</th><td>:</td>
					<td class="value"><input class="form-control" id="snnid"
						name="ssnid" type="text" value="db.getSSNid() %>"
						required></td>
				</tr>

				<tr>
					<th class="label">Customer Id</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="userid" type="text" value="db.getUserid() %>"
						required></td>
				</tr>
				
				<tr>
					<th class="label">Old Customer Name</th><td>:</td>
					<td class="value"><input class="form-control" id="customername"
						name="customername" type="text" value="db.getUsername() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">New Customer Name</th><td>:</td>
					<td class="value"><input class="form-control" id="customernewname"
						name="customernewname" type="text" required></td>
				</tr>

				<tr>
					<th class="label">Old Customer Address</th><td>:</td>
					<td class="value"><input class="form-control" id="customeraddr"
						name="customername" type="text" value="db.getUseraddr() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">New Customer Address</th><td>:</td>
					<td class="value"><input class="form-control" id="customernewname"
						name="customernewname" type="text" required></td>
				</tr>
				
				<tr>
					<th class="label">Old Age</th><td>:</td>
					<td class="value"><input class="form-control" id="oldage"
						name="oldage" value="db.getUseraddr() %>" ></td>
				</tr>
				
				<tr>
					<th class="label">New Age</th><td>:</td>
					<td class="value"><input class="form-control" id="newage"
						name="newage" type="number" required></td>
				</tr>
				
		</table>
		<br>
		<div>
				<button type="button" class="btn btn-success">Update</button>
		</div>
		<br>
	</form>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>