<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>

<div align="center" class="container" style="width:800px; background-color: rgba(0,0,255,0.1);">
	

		<h2>Registration Form</h2>

		<form action="welcomehome.jsp" >

			<table border="1" align="center">

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Age:</td>
					<td><input type="text" name="age"></td>
				</tr>
				<tr>
					<td>Profession:</td>
					<td><input type="text" name="prof"></td>
				</tr>
				<tr>
					<td>Agenda:</td>
					<td><textarea name="agenda" rows="10" cols="30">Enter your agenda here..</textarea></td>
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