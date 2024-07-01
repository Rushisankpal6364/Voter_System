<%@page import="beans123.VoterDao"%>
<%@page import="beans123.Voter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
Voter vote = VoterDao.getVoter(id);
%>

<form action="Update" method="POST">
<h1>Welcome to Update page</h1>
        <table>
        <tr>
            <td><label>Name :</label> </td>
            <td><input type="text" name="name" value="<%=vote.getName()%>"></td>
        </tr>
        <tr>
            <td>Last Name :</td>
            <td><input type="text" name="lastname" value="<%=vote.getLastname()%>"></td>   
        </tr>
        <tr>
            <td>Password :</td>
            <td><input type="text" name="password" value="<%=vote.getPassword()%>"></td>   
        </tr>
        <tr>
            <td>Age :</td>
            <td><input type="text" name="age" value="<%=vote.getAge()%>"></td>   
        </tr>
        <tr>
            <td>Location :</td>
            <td><input type="text" name="location" value="<%=vote.getLocation()%>"></td>   
        </tr>
        <tr>
            <td>Country :</td>
            <td><input type="text" name="country" value="<%=vote.getCountry()%>"></td>   
        </tr>
        
        <tr>
            <td><input type="hidden" name="id" value="<%=vote.getId()%>"></td>   
        </tr>
        <tr>
            <td>
                <button type="submit" name="btn" value="insert">Update</button>
            </td>
        </tr>
        
    </table>
    </form>
</body>
</html>