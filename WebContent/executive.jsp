<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Creat_customer_screen</title>

</head>
<body>

<div align="center">

<form>

<table>

<tr>
<td>
Customer SSN Id
</td>
<td>
<input id ="snnid"  name="ssnid" type="text" placeholder="1234 1234 1234 1234" required>
</td>
</tr>

<tr>
<td>
Customer Name
</td>
<td>
<input id ="customer_id"  name="customer_id" type="text"required>
</td>
</tr>

<tr>
<td>
Age</td>
<td>
<input id ="age"  name="age" type="number"required>
</td>
</tr>
<tr>
<td>
Address</td>
<td>
<input id ="address"  name="address" type="text" required>
</td>
</tr>



<tr>

<td>
State
</td>

<td>
<select onchange="print_city('state', this.selectedIndex);" name="state" id="sts" name ="stt" class="form-control" required></select>
</td>

</tr>

<tr>
<td>
City
</td>
<td>
<select id ="state" class="form-control" name="city" required></select>
</td>
</tr>

<tr>
<td>
<input type="submit" value="Submit" >
</td>
<td>
<input type="button" value="Reset" >
</td>
</tr>


</table>
</form>

</div>

    
</body>

<script type="text/javascript" src="resources/js/cities.js"></script>
 <script language="javascript">print_state("sts");</script>



</html>