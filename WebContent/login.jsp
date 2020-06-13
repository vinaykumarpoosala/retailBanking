<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC Bank</title>
<link href="resources/css/login.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
</head>
<body>

<div class="container">
	<div class="rsPgae">

		<h1 style="text-align: center;">Welcome to ABC Banking</h1>
		<form action="UserController" method="post">

			<fieldset>
				<h3>Login Here</h3>
				<hr>
				<br> <input type="text" name="userName" placeholder="UserName"
					style="text-align: center;"> <br> <br> <input
					type="password" name="password" placeholder="Password"
					style="text-align: center;"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					title="Must contain at least one uppercase , and at least 8 or more characters"
					required> <br> <br> <input type="submit"
					value="Login" name="action"> <input type="hidden"
					name="action" value="login">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

			</fieldset>

			<div id="message">
				<h3 id="messageToDisaplay"></h3>
				<p id="capital" class="invalid">
					A <b>capital (uppercase)</b> letter
				</p>
				<p id="length" class="invalid">
					Minimum <b>10 characters</b>
				</p>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="resources/js/login.js"></script>

	<div class="copyrighttt">
		<div class="container">
			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="copyright">
						<p>
							<strong>Copyright &copy2020 by ABC Retail Bank</strong>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>

</html>