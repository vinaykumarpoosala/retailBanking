<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>  
<head>  
<script>  
var request;  
function sendInfo()  
{  
var v=document.vinform.t1.value;  
var url="table2.jsp?val="+v;  
  
if(window.XMLHttpRequest){  
request=new XMLHttpRequest();  
}  
else if(window.ActiveXObject){  
request=new ActiveXObject("Microsoft.XMLHTTP");  
}  
  
try{  
request.onreadystatechange=getInfo;  
request.open("GET",url,true);  
request.send();  
}catch(e){alert("Unable to connect to server");}  
}  
  
function getInfo(){  
if(request.readyState==4){  
var val=request.responseText;  
document.getElementById('amit').innerHTML=val;  
}  
}  
  
</script>  
</head>  
<body>  
    <marquee><h1>This is an example of ajax</h1></marquee>  
<form name="vinform">  
Enter id:<input type="text" name="t1" onkeyup="sendInfo()">  
</form>  
  
<span id="amit"> </span>  
  
</body>  
</html>  