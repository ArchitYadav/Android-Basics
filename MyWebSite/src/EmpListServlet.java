

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmpListServlet")
public class EmpListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
  
    public EmpListServlet()
    {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","wimc","wimc");
		
			String q = "select * from Employee";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			
			PrintWriter writer = response.getWriter();
			
			while(rs.next())
			{
				String str = rs.getInt(1)+":"+rs.getString(2)+":"+rs.getInt(3);
				writer.println(str);
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException
	{
		
	}

}
