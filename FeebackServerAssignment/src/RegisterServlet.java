

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


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String city = request.getParameter("city");
		
		PrintWriter writer = response.getWriter();
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","wimc","wimc");
			
			String q = "insert into customer values(?,?,?,?)";
			PreparedStatement ps =con.prepareStatement(q);
			
			ps.setString(1,name);
			ps.setString(2, email);
			ps.setString(3,password);
			ps.setString(4,city);
			int r = ps.executeUpdate();
			if(r > 0)
				writer.println("Sucess");
			else
				writer.println("Faliure");
			
			ps.close();
			con.close();
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
