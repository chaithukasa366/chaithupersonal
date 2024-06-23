package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.connector.Response;

public class App extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ServletConfig config=getServletConfig();
		String lname=config.getServletName();
		String driverclass=config.getInitParameter("drivername");
		String url=config.getInitParameter("url");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		Enumeration e=config.getInitParameterNames();
		String paramnames="";
		while (e.hasMoreElements()) {
			paramnames=paramnames+e.nextElement()+"<br>";
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>");
		out.println("Logical name :"+lname+"<br>");
		out.println("Driver name :"+driverclass+"<br>");
		out.println("Driver url :"+url+"<br>");
		out.println("Username :"+username+"<br>");
		out.println("Password :"+password+"<br>");
		out.println(paramnames);
		out.println("</h2></body></html>");
	}

}
