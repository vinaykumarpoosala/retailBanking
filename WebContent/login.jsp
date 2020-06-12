<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retail Banking</title>
<link href="resources/css/login.css" rel="stylesheet">
</head>
<body>


<div class="rsPgae">
<form action="UserController" method="post">

    <fieldset align="center">
        <h3>Login here</h3><hr>
        <br>
        <label for="userName">User name</label>
        <input type="text" name="userName">
        <br>
        <br>
        <label for="password">password</label>
        <input type="password" name="password"><br>
        <br>
        <input type="submit" value="Login"> 
         <input type="hidden" name="action" value="login">
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
    </fieldset>
</form>

</div>
</body>
</html>