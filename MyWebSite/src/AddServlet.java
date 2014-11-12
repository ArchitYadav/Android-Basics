

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public AddServlet()
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		String d1 = request.getParameter("n1");
		String d2 = request.getParameter("n2");
		
		int a = Integer.parseInt(d1);
		int b = Integer.parseInt(d2);
		
		int c = a + b;
		
		PrintWriter writer = response.getWriter();
		writer.println("Sum:"+c);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		
	}

}
