<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create customer</title>
<link href="resources/css/login.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>

<%
if(session.getAttribute("TOKEN")==null)
{
	response.sendRedirect("login.jsp");
}
response.setHeader("Cache-Control","no-cache , no-store,must-revalidate");%>
	<%@ include file="header.jsp" %>

	<br>
	<h3 style="text-align: center;">Create Customer Data</h3>
	<br>

	<div>

	<form action="UserController" method="post">
			<table>

				<tr>
					<td class="label">Customer SSN Id</td>
					<td class="value"><input class="form-control" id="snnid"
						name="ssnid" type="text" placeholder="1234 1234"
						required></td>
				</tr>

				<tr>
					<td class="label">Customer Name</td>
					<td class="value"><input class="form-control" id="customer_id"
						name="customername" type="text" required></td>
				</tr>

				<tr>
					<td class="label">Age</td>
					<td class="value"><input class="form-control" id="age"
						name="age" type="number" required></td>
				</tr>
				<tr>
					<td class="label">Address</td>
					<td class="value"><input class="form-control" id="address"
						name="address" type="text" required></td>
				</tr>

				<tr>
					<td class="label">State</td>
					<td class="value"><select
						onchange="print_city('state', this.selectedIndex);" name="state"
						id="sts" name="stt" class="form-control" required
						style="margin: auto;"></select></td>

				</tr>

				<tr>
					<td class="label">City</td>
					<td class="value"><select id="state" class="form-control"
						name="city" required></select></td>
				</tr>

				<tr>
					<td class="label"></td>
					<td class="value"></td>
				</tr>

			</table>
			<span style="text-align: center; color: red; position: bottom;">All
				Fields are compulsory</span><br> <br>
			
			<div>
				<input type="hidden" name="action" value="createCustomer">
				<input type="submit" class="btn btn-dark">
				
				<button type="button" class="btn btn-dark pl-2">Reset</button>
			</div>
		</form>
		
		
				

	</div>
	
	
<div>	
<% String message = (String)request.getAttribute("customerId") ;%>
	<% if(message!="" || message!=null) {%>
	<span align="center">
	<p><%= message%></p>
	</span>
	<% } %>
<%@ include file="footer.jsp" %>
</div>

</body>



<script type="text/javascript" src="resources/js/cities.js"></script>
<script language="javascript">
	print_state("sts");
</script>



</html>