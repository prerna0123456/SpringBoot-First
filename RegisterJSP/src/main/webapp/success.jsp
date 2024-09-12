<%@ page language="java" errorPage="dberrors.jsp" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Received-Thank You</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
<body>

<%

String err =(String) request.getAttribute("error");

if(err !=null) {

%>

<div class="alert alert-warning" >You have an error in your submitted application. Kindly review and submit again.</div><h3></h3>

<% } else { %>

<div class="alert alert-success">Thanks for submitting your application. Our panel will review the details and get back to you shortly.

<div class="alert alert-success"> Your ticket is submitted. Ticket id:<%=request.getAttribute("ticket") %> </div>


</div>

<% } %>

<a href="register.jsp">Resubmit Application</a>

</body>
</html>

