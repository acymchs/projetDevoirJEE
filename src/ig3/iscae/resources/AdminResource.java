package ig3.iscae.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Administrateur;
import ig3.iscae.roles.Crenaux;
import ig3.iscae.roles.DirecteurEtude;
import ig3.iscae.roles.DirecteurGeneral;
import ig3.iscae.roles.Enseignant;
import ig3.iscae.roles.Matiere;
import ig3.iscae.service.AdminService;

@Path("/administrateur")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminResource {

AdminService adminServices=new AdminService();
	
	
	@GET
	@Path("/login")
	public Administrateur login(@QueryParam("login") String login,@QueryParam("password") String password) {
	return adminServices.getAdm();
	}
	
	
	
	
	//GET notre directeur General
	@GET
	@Path("/login/DG")
	public DirecteurGeneral dg() {
		return Memoire.getDirecteurG();
	}

	
	//GET notre directeur Etude
		@GET
		@Path("/login/DE")
		public DirecteurEtude de() {
			return Memoire.getDirecteurE();
		}
		
		
		//GET list des enseignants
		@GET
		@Path("/login/enseignants")
		public List<Enseignant> enseignants(){
			return adminServices.enseignants();
		}
	
		//GET list des matieres
				@GET
				@Path("/login/enseignants")
				public List<Matiere> matieres(){
					return adminServices.matieres();
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
	public DirecteurGeneral ajoutDG(@QueryParam("username") String username,@QueryParam("password") String password,DirecteurGeneral dg) {
		dg=new DirecteurGeneral(username,password);
		return adminServices.ajoutDirecteurG(dg);
		
	}
	
	@POST
	@Path("/login/ajoutDE")//ajouter des directeurs etudes
	public DirecteurEtude ajoutDE(@QueryParam("username") String username,@QueryParam("password") String password,DirecteurEtude dE) {
		dE=new DirecteurEtude(username,password);
		return adminServices.ajoutDirecteurE(dE);
	}
	
	
	@POST
	@Path("/login/addEnseignant")
	public Enseignant ajoutEnseignant(@QueryParam("nom") String nom,@QueryParam("prenom") String prenom,Enseignant enseignant) {
		enseignant=new Enseignant(nom,prenom);
		return adminServices.addEnseignant(enseignant);
	}
	
	@POST
	@Path("/login/addMatiere")
	public Matiere ajoutMatiere(@QueryParam("nom") String nom,Matiere m) {
		m=new Matiere(nom);
        return adminServices.addMatiere(m);
	}
	
	@POST
	@Path("/login/addCrenaux")
	public Crenaux ajoutCrenaux(@QueryParam("debut") String debut,@QueryParam("fin") String fin,Crenaux c) {
		c=new Crenaux(debut,fin);
        return adminServices.addCrenaux(c);
	}

}
