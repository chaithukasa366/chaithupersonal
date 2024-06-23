package servlet2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeadersServlet extends HttpServlet{
		private static final long serialVersionUID=1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		Enumeration<String> e=req.getHeaderNames();
		out.println("<html>");
		out.println("<body><center><br><br>");
		out.println("<table border='1' bgcolor='lightblue'>");
		out.println("<tr>  <td align='center'> <h3>Header Names</h3> </td> <td align='center'> <h3>Header Values</h3> </td></tr>");
	while (e.hasMoreElements()) {
		String header_name = (String) e.nextElement();
		String  header_value=req.getHeader(header_name);
		out.println("<tr><td>"+header_name+"</td><td>"+header_value+"</td></tr>");
		
	}
	 out.println("</table></center></body></html>");
	}
	
}
