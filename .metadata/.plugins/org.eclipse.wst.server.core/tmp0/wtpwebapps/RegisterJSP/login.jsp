<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Application Login</title>
<%--adding next 4 lines for bootstrap --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
td {
	background-color: silver;
}

h4{
background-color: lime;
align="center";
width="50%";
}
</style>
</head>
<body>

<nav class="navbar navbar-default">

<div class="container-fluid">

<div class="navbar-header">
<a class="navbar-brand" href="#">Brand Name</a>

</div>
<ul class ="nav navbar-nav">

<li class="active"> <a href="#">Home</a></li>

<li> <a href="#">About Us</a></li>

<li> <a href="#">Employee Corner</a></li>

<li> <a href="#">Careers</a></li>

<li> <a href="register.jsp">Contact</a></li>

<li> <a href="registered.jsp">Registered List</a></li>

<li> <a href="logout.jsp">Logout</a></li>

</ul>

</div>

</nav>


	<div align="center">
	
		<%String skipp =(String)request.getAttribute("isSkip");
		if(skipp!=null){
			System.out.println("skipp error: "+skipp);
			out.println("<h4>"+skipp+"<h4>");
		}%>
		<%
		String error = (String) session.getAttribute("err");
		if (error != null) {
		%>

		<h1><%=session.getAttribute("err")%></h1>
		<br>
		<%
		}
		%>
		<%session.setAttribute("err", null); %>

		<h2>Application Login</h2>

		<form action="validate.jsp">

			<table border="1">

				<tr>
					<td>Login:</td>
					<td><input type="text" name="uname"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pwd"></td>
				</tr>
			</table>
			<br>
			<br>
			<button type="submit">Submit</button>
			<button type="reset">Clear</button>



		</form>
	</div>

</body>
</html>