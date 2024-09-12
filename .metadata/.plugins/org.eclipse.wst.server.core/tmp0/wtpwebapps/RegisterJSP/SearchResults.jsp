<%@ page language="java"  import="java.util.ArrayList" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, register.servletex.User" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body{
background-color: #FAEBD7;
}
table{
border: 1px solid;
width: 100%;
}

tr:nth-child(even) {background-color: #f2f2f2;}

th{
font-size: 3em;
border: 2px solid;
background-color: #F0FFFF;
text-align: center;
height: 70px;
}

td{
border: 2px solid;
background-color: #F8F8FF;
text-align: center;
height: 50px;
}

</style>
</head>
<body>



<%

ArrayList<User> users=(ArrayList<User>)request.getAttribute("searchedUser");

if(users.isEmpty()){
	
	 RequestDispatcher dispatcher = request.getRequestDispatcher("emptySearch.jsp");
	    
	 dispatcher.forward(request, response);
	
}else{
	
	%>
	
<h2 align="center">Here are the users with name you searched</h2>	
	<table>
	<tr><th><strong>Name</strong></th><th><strong>Age</strong></th><th><strong>Profession</strong></th>
	<%


for(User u:users){
	
	%>
	
	
	<tr><td><%=u.getName() %></td><td><%=u.getAge() %></td><td><%=u.getProfession()%></td></tr>
	
	
	<%
	
} %>

</table>
<%
}

%>
</body>
</html>