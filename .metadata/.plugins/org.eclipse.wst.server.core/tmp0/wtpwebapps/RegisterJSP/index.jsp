<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><%-- Directive/import statements --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to JSP</title>
<style type="text/css">

h2{
background-color:pink; 
}
h3,h4 {
background-color: aqua;
}


</style>
</head>
<body>
<%@include file="header.jsp" %>
<%--This is JSP comment --%>

<% %><%--This is a scriptlet --%>
<%

int count=1;
double n=Math.random();
if(n>=0.93){
%>
<h4>It's your lucky day</h4>
<%
} else{
%>
<h4>Better luck next time</h4>
<%
}
%>
<h3>Initial value of count is <%=count %></h3>
<h2>This is your first JSP page</h2>
<h2>Random number n is: <%=n %></h2>

<a href="second.jsp">Click & see</a><br>
<a href="<%= request.getRequestURI()%>">Refresh</a><br>
<a href="login.jsp">Login</a><br>
<a href="register.jsp">Register</a>

<%
System.out.println("Request URI"+ request.getRequestURI());
%>

</body>
</html>