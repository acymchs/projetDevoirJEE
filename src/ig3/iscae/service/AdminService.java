package ig3.iscae.service;

import ig3.iscae.memoire.Memoire;
import ig3.iscae.roles.Administrateur;

public class AdminService {

private Administrateur adm=new Administrateur();
	
	

	
	public Administrateur getAdm() {

		
		return Memoire.getAdmin();
	}
	
	
	//admin peut changer le login et password par default
	public Administrateur changePassWord(Administrateur admin) {

		adm=new Administrateur(admin);
		
		Memoire.setAdmin(adm);
		
		
		return Memoire.getAdmin();
		
	}
}
