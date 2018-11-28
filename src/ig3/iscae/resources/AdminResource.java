package ig3.iscae.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Administrateur;
import ig3.iscae.roles.DirecteurGeneral;
import ig3.iscae.service.AdminService;

@Path("/administrateur")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

AdminService adminServices=new AdminService();
	
	
	@GET
	@Path("/login")
	public Administrateur login(@QueryParam("login") String login,@QueryParam("password") String password) {
		
		//verifier si le login est dans la memoire
		
		if(login.equals(Memoire.getAdmin().getLogin()) && password.equals(Memoire.getAdmin().getPassword())) {
			Administrateur adm=new Administrateur(login,password);
			adminServices.setAdm(adm);
			return adminServices.getAdm();
		}
		
		
		return null;//aucun resultat a retourner
		
	}
	//afficher list des DGs 
	@GET
	@Path("/login/directeurs")
	public List<DirecteurGeneral> getDirecteurs(){
		return adminServices.getListDG();
	}
	
	
	@PUT
	//maper le lien pour changer mot de passe etape 2
	@Path("/login/changepassword")
	public Administrateur changePassWord(@QueryParam("login") String login,@QueryParam("password") String password,Administrateur admin) {
	   admin=new Administrateur(login,password);
	   return adminServices.changePassWord(admin);
	   
	}
	
	
	@POST
	@Path("/login/ajoutDG")//ajouter des directeurs generales
	public DirecteurGeneral ajoutDG(DirecteurGeneral dg) {
		
		return adminServices.ajoutDirecteurG(dg);
		
	}
}
