package ig3.iscae.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcceptCnxDE extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		// positionne le ServletConfig
		 
		super.init(config);
		// initialise une variable d'état de la servlet
		
		
		}
	
	public void service(HttpServletRequest req, HttpServletResponse rep) throws IOException{
		rep.setContentType("text/html");
		PrintWriter out = rep.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE>welcome</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H1>Welcome le directeur "+req.getParameter("username")+" vous etes connecte Maintenant</H1>");
		out.println("</BODY></HTML>");
		out.close();
	}
	
}
