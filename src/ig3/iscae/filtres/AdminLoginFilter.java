package ig3.iscae.filtres;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.ws.rs.ext.Provider;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.resources.AdminResource;

@Provider
public class AdminLoginFilter implements Filter {

	private String typeCodage=null;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest requete, ServletResponse reponse, FilterChain chain)
			throws IOException, ServletException {
		reponse.setContentType("text/html");
		PrintWriter out = reponse.getWriter();
		String login=requete.getParameter("login");
		String password=requete.getParameter("password");
		AdminResource adm=new AdminResource();
		
//		if(login.equals(adm.login().getLogin()) && password.equals(Memoire.getAdmin().getPassword())) {
//			
			//envoyer vers la sevlet du welcome notre administrateur!!
			chain.doFilter(requete, reponse);
//		}
//		else {
//			
////			out.println("<HTML>");
////			out.println("<HEAD><TITLE>Servlet FOO</TITLE></HEAD>");
////			out.println("<BODY>");
////			out.println("<H1>it's first filter</H1>");
////			out.println("</BODY></HTML>");
////			out.close();
//			System.out.println("Filter");
//			//ne bouger pas vers la servlet du welcome il faut une autre requete GET!!!
//		}
//		
	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		typeCodage=conf.getInitParameter("Codage");
	}

}
