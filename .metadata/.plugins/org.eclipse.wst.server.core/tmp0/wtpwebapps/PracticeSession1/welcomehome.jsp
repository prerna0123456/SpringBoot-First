<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center">

			<% 
			String user1=request.getParameter("name");
			session.setAttribute("username", user1); 
			
			%>		


<h3>Welcome, User <%= session.getAttribute("username") %></h3><br><br>

<a href="logout.jsp">Logout</a>
</div>

</body>
</html>