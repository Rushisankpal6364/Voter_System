package beans123;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"));
		String location = request.getParameter("location") ;
		String country = request.getParameter("country");
		
		int status = VoterDao.UpdateVoter(name, lastname, password, age, location, country, id);
		
		if(status == 1) {
			response.sendRedirect("display.jsp");
			System.out.println("<----------Data Updated Successfully---------->");
		}else {
			response.sendRedirect("index.html");
			System.out.println("<----Unable to Update Data------>");
		}
	}

}
