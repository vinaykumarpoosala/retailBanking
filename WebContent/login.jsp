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

<h1 style="text-align: center;">Welcome to The Retail Banking</h1>
<form action="UserController" method="post">

    <fieldset align="center">
        <h3>Login here</h3><hr>
        <br>
        <label for="userName">User name</label>
        <input type="text" name="userName" id="userName" required>
        <br>
        <br>
        <label for="password">password</label>
        <input type="password" name="password" id="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one uppercase , and at least 8 or more characters" required><br>
        <br>
        <input type="submit" value="Login"> 
         <input type="hidden" name="action" value="login">
         
         
        
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        
    </fieldset>
    
    <div id="message">
  <h3 id="messageToDisaplay"> </h3>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="length" class="invalid">Minimum <b>10 characters</b></p>
</div>
</form>


</div>




</body>
<script type="text/javascript" src="resources/js/login.js"></script>

</html>