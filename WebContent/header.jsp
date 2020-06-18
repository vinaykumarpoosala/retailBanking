<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
</head>

<body>

	<div class="container-fluid nav-01">
		<div class="container pt-3">
			<!--first navbar  -->
			<nav class="navbar navbar-expand-lg navbar-light bg-dark p-0 mb-3">
				<div class="container nav-01 pl-0">
					<h2>
						<strong><span>ABC</span><span class="text-white pl-2">Bank
						</span></strong>
					</h2>
					
					<br>
				</div>
			</nav>
			
			<!--second navbar  -->
			<nav
				class="navbar navbar-expand-lg navbar-expand-md navbar-dark p-0 pt-2 pl-2"
				style="background-color: yellow; color: black">
				<div class="navbar-nav">
					<a class="nav-item nav-link active text-dark" href="home.jsp">Home
						<span class="sr-only">(current)</span>
					</a> <a>
						<ul class="p-0">
							<li class="nav-item dropdown nav-link p-0 text-dark" id="cm"><a
								class="nav-link dropdown-toggle text-dark" href="#"
								id="navbarDropdown" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Customer
									Management </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown" id="cc">
									<a class="dropdown-item" href="executive.jsp" >Create
										Customer</a> 
									<a class="dropdown-item" href="search_update.jsp" id="uc">Update Customer</a>
									<a class="dropdown-item" href="search_delete.jsp" id="dc">Delete Customer</a>
								</div></li>
						</ul>
					</a>
					
					<!--Third menu item  -->
					<a>
						<ul class="p-0">
							<li class="nav-item dropdown nav-link p-0 text-dark" id="am"><a
								class="nav-link dropdown-toggle text-dark" href="#"
								id="navbarDropdown" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Account
									Management </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown" id="cra">
									<a class="dropdown-item" href="create_account.jsp" >Create Account</a> <a
										class="dropdown-item" href="AccountController?action=AccountToDelete" id="da">Delete Account</a>
								</div></li>
						</ul>
					</a> <a>
						<ul class="p-0">
							<li class="nav-item dropdown nav-link p-0 text-dark " id="Stat"><a
								class="nav-link dropdown-toggle text-dark" href="#"
								id="navbarDropdown" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Status Details </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="UserController?action=customerstatus">Customer status</a> <a
										class="dropdown-item" href="AccountController?action=accountstatus">Account Status</a>
								</div></li>
						</ul>
					</a> <a>
						<ul class="p-0">
							<li class="nav-item dropdown nav-link p-0 text-dark " id="Acc"><a
								class="nav-link dropdown-toggle text-dark" href="#"
								id="navbarDropdown" role="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"> Account
									Operations </a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="search_deposit.jsp">Deposit Amount</a> <a
										class="dropdown-item" href="search_withdraw.jsp">Withdraw Amount</a> <a
										class="dropdown-item" href="search_transfer.jsp">Transfer Amount</a>
										<a
										class="dropdown-item" href="account_statement.jsp">Account statement</a>
								</div></li>
						</ul>
					</a> <a class="nav-item nav-link active text-dark" href="Logout" onclick="destry()"> Logout</a>

				</div>
			</nav>
		</div>
	</div>
	
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	<script>
	document.onreadystatechange = function () {
		     console.log(sessionStorage.getItem("userType"))
		  if (document.readyState === 'complete') {
			  if(sessionStorage.getItem("userType")==="CASHIER"){
                  document.getElementById("uc").style.visibility = "hidden"
                	  document.getElementById("dc").style.visibility = "hidden"
                		  document.getElementById("da").style.visibility = "hidden"
                			  document.getElementById("cra").style.visibility = "hidden"
                    			  document.getElementById("cc").style.visibility = "hidden"

                				  
                			  
     }
		  }
		     if (document.readyState === 'complete') {
				  if(sessionStorage.getItem("userType")==="EXCECUTIVE"){
	                  document.getElementById("Acc").style.visibility = "hidden"
	                	  
	     }
			  }
		}
	                       
                 
                 
                 function destry(){
                	 sessionStorage.removeItem("userType");
                 }
                 
	    
	</script>
	
	
</body>

	

</html>