

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try 
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "wimc", "wimc");
			String q = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			PrintWriter writer = response.getWriter();
			int flag = 0;
			while (rs.next())
			{
				String email1 = rs.getString(2);
				String password1 = rs.getString(3);
				
			System.out.println(email1 + password1 );
				
				if(email.equals(email1) && password.equals(password1))
				{
					writer.println("Login Successful");
					flag = 1;
					break;
				}
			
			}
			if(flag == 0)
			{
				writer.println("Login Unsuccessful");
			}
			
			rs.close();
			stmt.close();
			con.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
