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

HttpSession s=request.getSession();
int id=(Integer)s.getAttribute("id");
%>
  <form action="Vote" method="POST">
  <h2>Please Do Your Vote</h2>
  <table class="table">
  <tr>
    
    <th>Party</th>
    <th>Vote</th>
    </tr>
    
          <tr>
            <td><label for="vote">  BJP</label></td>
            <td><input type="radio" name="party" id="vote1" value="BJP" checked/><label for="vote1"></label>
          </tr>
          <tr>
            <td><label for="vote"> Congress</label></td>
            <td><input type="radio" name="party" id="vote2" value="Congress" checked/><label for="vote2"></label>
          </tr>
          <tr>
            <td><label for="vote"> Shivsena</label></td>
            <td><input type="radio" name="party" id="vote3" value="Shivsena" checked/><label for="vote3"></label>
          </tr>
          <tr>
            <td><label for="vote"> NCP</label></td>
            <td><input type="radio" name="party" id="vote4" value="NCP" checked/><label for="vote4"></label>
          </tr>
          <tr>
            <td><label for="vote"> AAP</label></td>
            <td><input type="radio" name="party" id="vote5" value="AAP" checked/><label for="vote5"></label>
          </tr>
          <tr>
            <td><label for="vote"> NOTA</label></td>
            <td><input type="radio" name="party" id="vote6" value="NOTA" checked/><label for="vote6"></label>
          </tr>
          <tr>
          
          <tr>
            <td><input type="hidden" name="id" value="<%=id%>"></td>   
        </tr> 
            <td>
                <button type="submit" name="btn" value="submit">Submit</button>
            </td>
        </tr>
   </table>
   </form> 
</body>
</html>