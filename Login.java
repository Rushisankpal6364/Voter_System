package beans123;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Votersystem","root","Rushikesh@123");
			Statement stmt=con.createStatement();
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			 boolean flag1 = VoterDao.getName(name);
				
				if(flag1 == true) {
					out.print("You are already voted..Thankyou...!");
					RequestDispatcher rd = request.getRequestDispatcher("login.html");
					rd.include(request, response);
				}
		
			
			ResultSet rs=stmt.executeQuery("select * from voter where name='"+name+"' and password='"+password+"' ");
			
			if(rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("id",rs.getInt("id"));
					response.sendRedirect("Welcome.jsp");
					
			}else{
				out.print("Invalid Credentials Please Enter Valid Details...!");
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			
		}
			
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}
