<%@page import="beans123.VoterDao"%>
<%@page import="beans123.Voter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
List<Voter> list = VoterDao.getAllVoter();
%>

<table class="table">
    <tr>
    <th>id</th>
    <th>name</th>
    <th>lastname</th>
    <th>password</th>
    <th>age</th>
    <th>location</th>
    <th>country</th>
    <th>Delete Option</th>
    <th>Update Option</th>
    </tr>
    
    	<%for(Voter voter:list){ %>
		<tr>
			<td><%=voter.getId() %></td>
		    <td><%=voter.getName() %></td>
			<td><%=voter.getLastname() %></td>
			<td><%=voter.getPassword() %></td>
			<td><%=voter.getAge() %></td>
			<td><%=voter.getLocation() %></td>
			<td><%=voter.getCountry() %></td>
			<td><button><a href='Delete?id=<%=voter.getId()%>'>Delete</a></button></td>
		    <td><button><a href='Update.jsp?id=<%=voter.getId()%>'>Update</a></button></td>
		   
		</tr>
	<%} %>

</table>
</body>
</html>