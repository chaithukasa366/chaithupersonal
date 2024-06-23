package ser;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;



public class Home extends HttpServlet {
	
	String url = "jdbc:mysql://localhost:3306/chaithu";
	String username = "root";
	String password = "root";
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			System.out.println("connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		System.out.println("start");
		String s="select * from student where usn=? ";
		String usn=req.getParameter("usn");
		try {
			pstmt=con.prepareStatement(s);
			pstmt.setString(1, usn);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				int a=rs.getInt(2);
				String b=rs.getString(1);
				int c=rs.getInt(4);
				String d=rs.getString(3);
				PrintWriter out=res.getWriter();
				out.println(a);
				out.println(b);
				out.println(c);
				out.println(d);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
	try {
		con.close();
		System.out.println("close");
	} catch (Exception e) {
		e.printStackTrace();
	}	
	}
}
