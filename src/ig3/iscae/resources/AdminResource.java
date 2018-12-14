package ig3.iscae.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        @Path("/login/matieres")
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
	
	
	
	//Methode pour chaque enseignant on ajout ses matieres une par une!!
	@PUT
	@Path("/login/gestionDesEnseignants")
	public Enseignant enseigner(@QueryParam("matiere") String matiere,@QueryParam("idEnseignant") Integer id,Enseignant e,Matiere m) {//web service qui affecte les matieres aux enseignants
		
		if(Memoire.getEnseignants().isEmpty() && Memoire.getMatieres().isEmpty()) {
			return null;
		}
		else {
			if(!(Memoire.getEnseignants().containsKey(id) && Memoire.getMatieres().containsKey(matiere))) {//si l'un des matiere ou l'enseignant n'est pas encore ajouter rien a retourne
				return null;
			}
			else {
				       e=Memoire.getEnseignants().get(id);
				       m=Memoire.getMatieres().get(matiere);
				       if(m.getEnseignant()==null) {
					                      e.setMatieres(m);//voir le setters des matiere class Enseignant
					                     m.setEnseignant(e.getNom()+" "+e.getPrenom());//pour identifier l'enseignant de la matiere
				        }
				       else return null;
				  }
			}
		return e;
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
		if(Memoire.getEnseignants().isEmpty()) {//si aucun enseignant est ajoute par les directeurs! C-a-d memoire vide
			return adminServices.addEnseignant(enseignant);
		}
		
	//si un tel enseignant sera ajouter avec le meme nom et prenom q'un autre existe deja
		//un test sera recommender ici!
		
		else {
			//une boucle pour tester les noms et les prenoms
			
			for(int i=1;i<=Memoire.getEnseignants().size();i++) {
				//pour chaque enseignant on verifer qu'il n'ya pas les meme noms et prenoms que celui ci, 
				//on joue sur les IDs auto-incremente de la memoire voir methode addEseignant() du class AdminServices
				
				if(Memoire.getEnseignants().get(i).getNom().equals(nom)) {
					if(Memoire.getEnseignants().get(i).getPrenom().equals(prenom)) {
						return null;//Rien a ajouter et il sera besoin une autre GET!!
					}
				}
			}
		}
	 return adminServices.addEnseignant(enseignant);
	}	

	    
	

	
	
	@POST
	@Path("/login/addMatiere")
	public Matiere ajoutMatiere(@QueryParam("nom") String nom,Matiere m) {
		 
			m=new Matiere(nom);
			if(Memoire.getMatieres().isEmpty()) {
				return adminServices.addMatiere(m);
			}
			
			else {
				for(int i=1;i<=Memoire.getMatieres().size();i++) {
					if((Memoire.getMatieres().containsKey(nom))) {//les cles du Map dans la memoire son des String(les noms des matieres car le nom doit etre unique
						return null;
					}
				}
			}
			return adminServices.addMatiere(m);
		
        
	}
	
	
	
	@POST
	@Path("/login/addCrenaux")
	public Crenaux ajoutCrenaux(@QueryParam("jour") String jour,@QueryParam("debut") String debut,@QueryParam("fin") String fin,
								@QueryParam("matiere") String matiere,Matiere m,Crenaux c) {
		
	   c=new Crenaux(jour,debut,fin);
	  if(Memoire.getCrenaux().isEmpty()) {
		  if(Memoire.getMatieres().isEmpty()) {
			  return null;
		  }
		  else if(Memoire.getMatieres().containsKey(matiere)) {
			  m=Memoire.getMatieres().get(matiere);
			  c.setMatiere(m);
		  }
		  else return null;
	  }
	  else {
		  if(Memoire.getMatieres().containsKey(matiere)) {
			  if(c.getMatiere()!=null) {
				  return null;
			  }
			  else {
				  m=Memoire.getMatieres().get(matiere);
				  c.setMatiere(m);
			  }
		  }
		  
		  return adminServices.addCrenaux(c);
	  }
       return adminServices.addCrenaux(c);// un crenaux pas cours :D
	}
	
	
	

}
