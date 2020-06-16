<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.*"%>  
  
<%  
String s=request.getParameter("val");  
if(s==null || s.trim().equals("")){  
out.print("Please enter id");  
}else{  
int id=Integer.parseInt(s);  
out.print(id);  

}  
%>  