

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String password=request.getParameter("passw");
		String email=request.getParameter("eid");
		String gender=request.getParameter("gender");
		long mobile_number=Long.parseLong(request.getParameter("phno"));
		String state=request.getParameter("state");
		
		String country=request.getParameter("country");
		String address=request.getParameter("addr");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, gender);
			ps.setLong(5, mobile_number);
			ps.setString(6, state);
			ps.setString(7, country);
			ps.setString(8, address);
			
			int i=ps.executeUpdate();
			out.print("<center><b><h2>"+"1 record inserted successfully");
		}
		catch(Exception e){
			out.print(e);

	}
	
	
	
	}

}
