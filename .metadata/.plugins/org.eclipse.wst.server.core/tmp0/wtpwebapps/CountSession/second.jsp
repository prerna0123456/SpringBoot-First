<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Http Headers</title>
</head>
<body>

<table align="center" border="1">

<tr><th>Header Name</th><th>Header Value</th></tr>

<%
String name=null;
String value=null;
Enumeration<String> headers = request.getHeaderNames();

while(headers.hasMoreElements()){
	
	name=(String)headers.nextElement();
	value=request.getHeader(name);



%>
<tr><td><%=name %></td><td><%=value %></td></tr>
<%
}
%>
</table>

</body>
</html>