 <%@include file="header.jsp" %>

<div align="center">

<h3>Welcome, User <%= session.getAttribute("username") %></h3><br><br>

<a href="logout.jsp">Logout</a>
</div>
</body>
</html>