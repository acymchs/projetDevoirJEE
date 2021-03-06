package ig3.iscae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Crenaux;
import ig3.iscae.roles.DirecteurEtude;
import ig3.iscae.roles.DirecteurGeneral;
import ig3.iscae.roles.Enseignant;
import ig3.iscae.roles.Matiere;

public class DGService {

	
	private Map<String, Matiere> matieres=Memoire.getMatieres();
	private List<Crenaux> crenaux=Memoire.getCrenaux();
	
			
			//ajout des matieres
			public Matiere addMatiere(Matiere matiere) {
					matieres.put(matiere.getNom(), matiere);
				return matiere;
			}
			
			//list des matieres
					public List<Matiere> matieres() {
						return new ArrayList<Matiere>(matieres.values());
					}

					public DirecteurGeneral connexion() {
						// TODO Auto-generated method stub
						return Memoire.getDirecteurG();
					}
		
		
					 public Crenaux addCrenaux(Crenaux crenaux) {				
							this.crenaux.add(crenaux);
							return crenaux;
							}	
					
		       
	
}
