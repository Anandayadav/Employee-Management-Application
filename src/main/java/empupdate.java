

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
 * Servlet implementation class empupdate
 */
@WebServlet("/empupdate")
public class empupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empupdate() {
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
		long mobno=Long.parseLong(request.getParameter("phno"));
		String address=request.getParameter("addr");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","andb","andb");
			PreparedStatement ps=con.prepareStatement("update Employee set password=?,email=?,Mobile_number=?,address=? where name=?");
			
			ps.setString(1, password);
			ps.setString(2, email);
			ps.setLong(3, mobno);
			ps.setString(4, address);
			ps.setString(5, name);
			
			
			int i=ps.executeUpdate();
			out.print(i+"record updated successfully");
		}
		catch(Exception e){
			out.print(e);

	}

	}

}
