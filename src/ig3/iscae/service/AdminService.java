package ig3.iscae.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Administrateur;
import ig3.iscae.roles.DirecteurGeneral;

public class AdminService {

private Administrateur adm=new Administrateur();
private Map<String,DirecteurGeneral> directeurs=Memoire.getDirecteurs();
	

	
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
	
	//etape 3 ajout du directeur
	public DirecteurGeneral ajoutDirecteurG(DirecteurGeneral dg){
		directeurs.put(dg.getLoginDG(), dg);
		return dg;
	}
	
	
	//afficher list des directeurs ajoutes
	public List<DirecteurGeneral> getListDG(){
		return new ArrayList<DirecteurGeneral>(directeurs.values());
		
	
	}
	
}
