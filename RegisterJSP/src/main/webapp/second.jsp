<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Second JSP Page</title>
<style type="text/css">

h3{
background-color: fuchsia;
}
</style>
</head>
<body>

<h3>Second JSP page</h3>
<a href="<%= request.getRequestURI()%>">Refresh</a><%--refreshes the page because it gives back url to same page --%>
<%!int attempt=0; %>
<%! void increaseAttempt(){attempt=attempt+1;} %>


<h3>Today is <%= new Date() %></h3>


</body>
</html>