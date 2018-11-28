package ig3.iscae.memoire;

import java.util.HashMap;
import java.util.Map;

import ig3.iscae.roles.Administrateur;
import ig3.iscae.roles.DirecteurGeneral;

public class Memoire {

	private static Administrateur admin=new Administrateur("admin","admin");// Etape 1 un seul admin par defaut a changer
    private static Map<String,DirecteurGeneral> directeurs=new HashMap<>();
	
	

	public static Administrateur getAdmin() {
		return admin;
	}

	public static void setAdmin(Administrateur admin) {
		Memoire.admin = admin;
	}

	public static Map<String, DirecteurGeneral> getDirecteurs() {
		return directeurs;
	}

	public static void setDirecteurs(Map<String, DirecteurGeneral> directeurs) {
		Memoire.directeurs = directeurs;
	}
	
	
}
