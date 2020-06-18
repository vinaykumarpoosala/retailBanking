<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
	<main role="main">
			<div class="jumbotron">
				<div class="col-sm-8 mx-auto">
				<p> You are assigned For <%=userType.toLowerCase() %> Role </p>
					<span style="text-align: center;"> 
								<p>
									<strong>${message}</strong>
								</p>
							</span>
					<br>
					
				</div>
			</div>
		</main>
		</div>

<%@ include file="footer.jsp" %>
</body>

<script>
	sessionStorage.setItem("userType",
			document.getElementById("user_Type").value);
	console.log(document.getElementById("user_Type").value)
</script>

</html>