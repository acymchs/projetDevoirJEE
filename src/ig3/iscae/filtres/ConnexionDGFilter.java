package ig3.iscae.filtres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ig3.iscae.memoire.Memoire;

public class ConnexionDGFilter implements Filter{
	private String typeCodage=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest requete, ServletResponse reponse, FilterChain ch)
			throws IOException, ServletException {
		reponse.setContentType("text/html");
		PrintWriter out = reponse.getWriter();
		String username=requete.getParameter("username");
		String password=requete.getParameter("password");
		
		if(!(username.equals(Memoire.getDirecteurG().getLoginDG())) || !(password.equals(Memoire.getDirecteurG().getPasswordDG()))) {
			out.println("<HTML>");
			out.println("<HEAD><TITLE>Ereur</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<H1>username ou Mot de passe invalide!!!</H1>");
			out.println("<H1>il faut une autre requete GET!!!</H1>");
			out.println("</BODY></HTML>");
			out.close();
		}

		else {
			ch.doFilter(requete, reponse);
			
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		typeCodage=arg0.getInitParameter("Codage");
		
	}

	
}
