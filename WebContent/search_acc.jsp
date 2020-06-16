<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
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

	<form action="UserController" method="post">
		<input type="hidden" name="action" value="search_account">
			<h3>Search Customer</h3>
			<br>
			<table>
				<tr>
					<th>Search with</th><td>-></td><td><select id="type" class="form-control"
						name="type" required>
						<option value="Select">---Select---</option>
						<option value="Account Id">Account Id</option>
						<option value="Customer Id">Customer Id</option>
						</select>
					</td>
				</tr>
				
			</table><br>
			<div style="text-align:center " ><input type="text" name="type" placeholder="Enter ID" required></div><br>
			<input type="submit" name="action" value="Submit" readonly>
		</form>
		<br>
	
	</div>

<%@ include file="footer.jsp" %>

</body>
</html>