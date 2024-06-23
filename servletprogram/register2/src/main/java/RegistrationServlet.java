

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		String sid = req.getParameter("sid");
		String sname = req.getParameter("sname");
		String[] squal = req.getParameterValues("squal");
		String sgender = req.getParameter("sgender");
		String[] stech = req.getParameterValues("stech");
		String sbranch = req.getParameter("branch");
		String saddr = req.getParameter("saddr");
		System.out.println(sid);
		
		  String qual=""; for (int i = 0; i < squal.length; i++) {
		  qual=qual+squal[i]+"<br>";
		  
		  }
		  
		  String tech=""; for (int i = 0; i < stech.length; i++) {
		  tech=tech+stech[i]+"<br>";
		  
		  }
		  
		 
		out.println("<html>");
		out.println("<body>");
		out.println("<font color='red'>");
		out.println("<h2>Greemus solutions</h2>" + "	<h3>Student Registration Form</h3>");
		out.println("</font>");
		out.println("<table border='1'>");
		out.println("<tr><td>Student Id</td><td>" + sid + "</td></tr>");
		out.println("<tr><td>Student Name</td><td>" + sname + "</td></tr>");
		out.println("<tr><td>Student Qualification</td><td>" + qual + "</td></tr>");
		out.println("<tr><td>Student Gender</td><td>" + sgender + "</td></tr>");
		out.println("<tr><td>Student Technologies</td><td>" + tech + "</td></tr>");
		out.println("<tr><td>Branch</td><td>" + sbranch + "</td></tr>");
		out.println("<tr><td>Student Address</td><td>" + saddr + "</td></tr>");
		out.println("</table></body></html>");

	}
}
