<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Bank</title>
<link href="resources/css/login.css" rel="stylesheet">
</head>
<body>


	<div class="rsPgae">

		<h1 style="text-align: center;">Welcome to The Retail Banking</h1>
		<form action="UserController" method="post">

			<fieldset >
				<h3>Login here</h3>
				<hr>
				<br> <input type="text" name="userName" placeholder="UserName" style="text-align:center; ">
				<br> 
				<br> <input type="password" name="password"	placeholder="Password" style="text-align:center; ">
				<br> 
				<br> 
				<input type="submit" value="Login"> <input type="hidden" name="action" value="login">

				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			</fieldset>
		</form>

	</div>
</body>
<br>
<br>
<footer>
	<strong> Copyright &copy2020 by ABC Retail Bank </strong>
</footer>
</html>