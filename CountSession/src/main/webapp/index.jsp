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
	Integer count;
	count = (Integer) session.getAttribute("countsess");

	if (count == null) {
		count = 1;
	} else {
		count++;
	}

	session.setAttribute("countsess", count);
	%>

	<h3>
		Number of website is refreshed is
		<%=count%></h3>

</body>
</html>