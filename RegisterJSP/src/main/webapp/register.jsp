
<%@include file="header.jsp" %>

<div class ="container" style="width:800px; background-color: rgba(0,0,255,0.1);">


<h2>Registration Form:</h2>

<%
String attr = (String)session.getAttribute("username");
if(attr ==null) {
System.out.println("Trying to skip login.. ");
request.setAttribute("isSkip", "Login is required to access registration page!!");
request.getRequestDispatcher("login.jsp").forward(request, response);

} else {
System.out.println("Login success. ");

}
%>

<form action="registeruser" method="post" >

<label for="uname">Name</label>
<input type="text" required="required" style="width:300px;" class="form-control w-25" id="uname" name="name">
<label for="uage">Age</label>
<input type="text" required="required" style="width:300px;" name="age" id="uage" class="form-control w-50">
<label for="uprof">Profession</label>

<input type="text" required="required" name="prof" id="uprof" class="form-control">
<label for="uagenda">Agenda</label>

<textarea name="agenda" required="required" id="uage" class="form-control" rows="10" cols="40"></textarea>

<button type="submit" class="btn btn-primary">Submit</button>

<button type="reset" class="btn btn-primary">Clear</button>

</form>

</div>

<br><br>

<hr>

<%@include file="footer.jsp" %>
</body>
</html>