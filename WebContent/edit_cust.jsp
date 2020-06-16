<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit customer</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

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
						name="ssnid" type="text" value=""
						required></td>
				</tr>

				<tr>
					<th class="label">Customer Id</th><td>:</td>
					<td class="value"><input class="form-control" id="customerid"
						name="userid" read-only type="text" value="db.getUserid() %>"
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
						name="customername" type="text" value="" ></td>
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
	
	<script>
	      
	     $(document).ready(function(){
	    	     var snnid
	    	     $("#snnid").change(function(){
	    	     snnid=$(this).val()
	             console.log(snnid)
	  
	             $.ajax({
	       		  url: "/usercontroller",
	       		  type: 'POST',
	       		  data: {snnid:snnid,action="search"},
	       		  success: function(data) {
	       		  $('#city_name').val(data);
	       		  alert(data);
	       		  var city_name = data;
	       		  
	       		  
	       		  $("#customeraddr").val(data.customerid)
	       		  
	       		  
	       		  },
	       		  error:function(err){
	       			  alert("err");
	       		  }
	       		  });
	       	    	 

	       		});
	  
	          })
	
	
	
	</script>
	

<%@ include file="footer.jsp" %>
</body>
</html>