package beans123;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("btn");
		
	    if(action.equals("insert")){
		
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String location = request.getParameter("location");
		String country = request.getParameter("country");
		
		boolean flag = VoterDao.getAge(age);
		
		if(flag == false) {
			out.print("You are below the age of 18 so You have no right to vote");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
	
		Voter voter = new Voter();
		
		voter.setName(name);
		voter.setLastname(lastname);
		voter.setPassword(password);
		voter.setAge(age);
		voter.setLocation(location);
		voter.setCountry(country);		

	
		int status = VoterDao.InsertVoter(voter);
		
		if(status == 1) {
			System.out.println("<----------Data Inserted---------->");
			out.print("<script>alert('data inserted...');window.location='index.html' </script>");
			
		}
		else {
		
			System.out.println("<----------Unable to Insert Data---------->");
		}
	}
		
	    
	}
	    if(action.equals("login")){
			response.sendRedirect("login.html");
		}
		
	}
}
