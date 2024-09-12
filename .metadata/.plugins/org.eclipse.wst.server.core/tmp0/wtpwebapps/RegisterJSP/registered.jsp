<%@page import="java.sql.*,java.util.*,register.servletex.User" %>
<%@include file="header.jsp"%>


<%!

String USER="root";
String KEY="password";
String URL="jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

%>

<%
Connection conn=DriverManager.getConnection(URL,USER,KEY);

Statement stmt=conn.createStatement();

String sqlstr="SELECT * FROM usersubmissions";

ResultSet rs=stmt.executeQuery(sqlstr);

List<User> allUsers=new ArrayList<>();

while(rs.next()){
	int appId=rs.getInt("application_id");
	int age=rs.getInt("age");
	String name=rs.getString("name");
	String profession=rs.getString("profession");
	String agenda=rs.getString("agenda");
	
	allUsers.add(new User(name,profession,age,agenda));
}


%>

<div class="container">
<table class ="table table-hover table-striped table-bordered" >
<caption><h2>List of users</h2></caption>
<thead class="thead-dark">
<tr>


<th scope="col">Name</th>
<th>Age</th>
<th>Profession</th>
<th>Agenda</th>
</tr>
</thead>
<%
for(User u:allUsers){
	%>
	
	<tr>
	<td><%=u.getName() %></td>
	<td><%=u.getAge() %></td>
	<td><%=u.getProfession() %></td>
	<td><%=u.getAgenda() %></td>
	</tr>
	
	<%
	}
	%>