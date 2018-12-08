package ig3.iscae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Administrateur;
import ig3.iscae.roles.Crenaux;
import ig3.iscae.roles.DirecteurEtude;
import ig3.iscae.roles.DirecteurGeneral;
import ig3.iscae.roles.Enseignant;
import ig3.iscae.roles.Matiere;

public class AdminService {

private Administrateur adm=new Administrateur();

private Map<Integer,Enseignant> enseignants=Memoire.getEnseignants();
private Map<Integer, Matiere> matieres=Memoire.getMatieres();
	private Crenaux crenaux=new Crenaux();
	public void setAdm(Administrateur adm) {
	this.adm = new Administrateur(adm);
	
}


	public Administrateur getAdm() {

		
		return Memoire.getAdmin();
	}
	
	
	//admin peut changer le login et password par default
	public Administrateur changePassWord(Administrateur admin) {

		adm=new Administrateur(admin);
		
		Memoire.setAdmin(adm);
		
		
		return Memoire.getAdmin();
		
	}
	
	//etape 3 ajout du directeur General
	public DirecteurGeneral ajoutDirecteurG(DirecteurGeneral dg){
		Memoire.setDirecteurG(dg);
		return dg;
	}
	
	//etape 3 ajout du directeur Etude
		public DirecteurEtude ajoutDirecteurE(DirecteurEtude de){
			Memoire.setDirecteurE(de);
			return de;
		}
		
		//ajout des enseigenants
		
		public Enseignant addEnseignant(Enseignant e) {
			e.setId(enseignants.size()+1);
			enseignants.put(e.getId(), e);
			return e;
		}
		//list des enseignants
		public List<Enseignant> enseignants() {
			return new ArrayList<Enseignant>(enseignants.values());
		}
		
		//ajout des matieres
		public Matiere addMatiere(Matiere matiere) {
			matiere.setId(matieres.size()+1);
			matieres.put(matiere.getId(), matiere);
			
			return matiere;
		}
		
		//list des matieres
				public List<Matiere> matieres() {
					return new ArrayList<Matiere>(matieres.values());
				}
				//ajout des crenaux
				public Crenaux addCrenaux(Crenaux crenaux) {				
					Memoire.setCrenaux(crenaux);
					return crenaux;
				}	
				
				
}
