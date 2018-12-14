package ig3.iscae.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Crenaux;
import ig3.iscae.roles.DirecteurEtude;
import ig3.iscae.roles.DirecteurGeneral;
import ig3.iscae.roles.Enseignant;
import ig3.iscae.roles.Matiere;
import ig3.iscae.service.DGService;
@Path("/DG")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DGResource {
	DGService DG=new DGService();
	
	
	@GET
	@Path("/cnx")
	public DirecteurGeneral login(@QueryParam("username") String username,@QueryParam("password") String password) {
	return DG.connexion();
	}
	
	
			//GET list des matieres
			@GET
	        @Path("/matieres")
			public List<Matiere> matieres(){
				return DG.matieres();
			}

	@POST
	@Path("/addMatiere")
	public Matiere ajoutMatiere(@QueryParam("nom") String nom,Matiere m) {
		 
			m=new Matiere(nom);
			if(Memoire.getMatieres().isEmpty()) {
				return DG.addMatiere(m);
			}
			
			else {
				for(int i=1;i<=Memoire.getMatieres().size();i++) {
					if((Memoire.getMatieres().containsKey(nom))) {//les cles du Map dans la memoire son des String(les noms des matieres car le nom doit etre unique
						return null;
					}
				}
			}
			return DG.addMatiere(m);
		
        
	}
	
	@POST
	@Path("/cnx/addCrenaux")
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
		  
		  return DG.addCrenaux(c);
	  }
       return DG.addCrenaux(c);// un crenaux pas cours :D
	}
	
}
