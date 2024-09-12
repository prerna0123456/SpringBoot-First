<%@ page language="java" errorPage="errors/numberformat.jsp"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Handling jsp exceptions</title>
</head>
<body>

<h2>Tyring for number format exception</h2>
<%

out.println(20/0);

%>
</body>
</html>