<%@page import="com.banking.beans.TransactionBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  
  
}
table
{
width: 750px}
</style>
<link href="resources/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<meta charset="ISO-8859-1">
<title>Account Transaction statement</title>
</head>
<body>
<% if(session.getAttribute("TOKEN")==null || session.getAttribute("TOKEN")=="")
{
	response.sendRedirect("login.jsp");
}
response.setHeader("Cache-Control","no-cache , no-store,must-revalidate");%>
<% String userType = (String)session.getAttribute("USER_TYPE"); %>

<%@ include file="header.jsp" %>


	<form action="Transaction?action=getStatement" method="post">
	<h3>Account statement</h3><br>
		<input type= "text" id="acc_id"  placeholder="accountId" "form-control"
						name="account_id" >
						
						
					

	<!-- 	<tr>
					<th class="label">Account Type</th><td>:</td>
					<td class="value"><input class="form-control" id="account_type"
						name="account_type"  placeholder="Account type" ></td>
				</tr>
				 -->
				 
				 <input type="submit" value="searchAccount">
				
				
		
		
		
		
				
		<br>
	</form>
	
	
<!--  
    $('#example').DataTable( {
        "pagingType": "full_numbers"
    } );
} );</script>


   
    
 <script>
    function createPDF() {
        var sTable = document.getElementById('tab').innerHTML;

        var style = "<style>";
        style = style + "table {width: 100%;font: 17px Calibri;}";
        style = style + "table, th, td {border: solid 1px #DDD; border-collapse: collapse;";
        style = style + "padding: 2px 3px;text-align: center;}";
        style = style + "</style>";

        // CREATE A WINDOW OBJECT.
        var win = window.open('', '', 'height=700,width=700');

        win.document.write('<html><head>');
        win.document.write('<title>Profile</title>');   // <title> FOR PDF HEADER.
        win.document.write(style);          // ADD STYLE INSIDE THE HEAD TAG.
        win.document.write('</head>');
        win.document.write('<body>');
        win.document.write(sTable);         // THE TABLE CONTENTS INSIDE THE BODY TAG.
        win.document.write('</body></html>');

        win.document.close(); 	// CLOSE THE CURRENT WINDOW.

        win.print();    // PRINT THE CONTENTS.
    }
</script>  

<!--  it will work if send data to anoatherpage instead of this page -->
<br>
<br>
<br>

<%@ include file="footer.jsp" %>
</body>
</html>