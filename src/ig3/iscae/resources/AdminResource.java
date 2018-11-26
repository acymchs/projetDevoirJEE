package ig3.iscae.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import ig3.iscae.roles.Administrateur;
import ig3.iscae.service.AdminService;

@Path("/administrateur")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

AdminService adminServices=new AdminService();
	
	
	
	@GET
	public Administrateur getAdmin() 
	{
		
		return adminServices.getAdm();
	}
	
	
	@PUT
	//maper le lien pour changer mot de passe etape 2
	@Path("/changepassword")
	public Administrateur changePassWord(@QueryParam("login") String login,@QueryParam("password") String password,Administrateur admin) {
	   admin=new Administrateur(login,password);
	   return adminServices.changePassWord(admin);
	   
	}
}
