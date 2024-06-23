package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class App1 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ServletContext context=getServletContext();
		String lname=context.getServletContextName();
		
		String driverclass=context.getInitParameter("drivername");
		String url=context.getInitParameter("url");
		String username=context.getInitParameter("username");
		String password=context.getInitParameter("password");
		Enumeration e=context.getInitParameterNames();
		String paramnames="";
		while (e.hasMoreElements()) {
			paramnames=paramnames+e.nextElement()+"<br>";
		}
		String eid=(String) context.getAttribute("eid");
		String ename=(String) context.getAttribute("ename");
		String ecost=(String) context.getAttribute("ecost");
		e=context.getAttributeNames();
		String attrnames="";
		while (e.hasMoreElements()) {
		attrnames= attrnames+ e.nextElement()+"<br>";
			
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
		out.println("course id:"+eid+"<br>");
		out.println("course name :"+ename+"<br>");
		out.println("course cost:"+ecost+"<br>");
		out.println("Attrnames :"+attrnames);
		out.println("</h2></body></html>");
		
	}

}
