

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


@WebServlet("/AddEmpServlet")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AddEmpServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		PrintWriter writer = response.getWriter();
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","wimc","wimc");
			
			String q = "insert into Employee values(?,?,?)";
			PreparedStatement ps =con.prepareStatement(q);
			
			ps.setInt(1,id);
			ps.setString(2, name);
			ps.setInt(3, salary);
			
			int r = ps.executeUpdate();
			if(r > 0)
				writer.println("Sucess");
			else
				writer.println("Faliure");
			
			ps.close();
			con.close();
		}
		catch (Exception e)
		{
			
		}
	}

}
