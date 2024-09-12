<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

String user=request.getParameter("uname");
String token=request.getParameter("pwd");

if(user.equals("admin")&&token.equals("password")){
	session.setAttribute("username", user);
	response.sendRedirect("welcomehome.jsp");
}else{
	session.setAttribute("err", "Authentication failure");
	
	response.sendRedirect("login.jsp");
}
%>

</body>
</html>