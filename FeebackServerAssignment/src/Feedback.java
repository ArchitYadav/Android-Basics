

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


@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Feedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String feedback = request.getParameter("feedback");
		
		PrintWriter writer = response.getWriter();
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","wimc","wimc");
			
			String q = "insert into feedback values(?,?)";
			PreparedStatement ps =con.prepareStatement(q);
			
			ps.setString(1,email);
			ps.setString(2, feedback);

			int r = ps.executeUpdate();
			if(r > 0)
				writer.println("Success");
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
