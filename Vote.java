package beans123;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Vote")
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Vote() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//int id = Integer.parseInt(request.getParameter("id"));
		
		
			
			String action = request.getParameter("btn");
			
			if(action.equals("submit")) {
				String party = request.getParameter("party");
				int votes = Integer.parseInt(request.getParameter("id"));
				
				Voter vote1 = new Voter();
				vote1.setParty(party);
				vote1.setVote(votes);
				
				int status = VoterDao.InsertParty(vote1);
				
				if(status == 1) {
					System.out.println("<-----Data Inserted----->");
					out.print("<script>alert('You have Voted Successfully');window.location='login.html'</script>");
				}else {
					System.out.println("<-----Unable to insert Data----->");
				}
				
			}
	}
}
