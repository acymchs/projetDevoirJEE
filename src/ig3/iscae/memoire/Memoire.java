package ig3.iscae.memoire;

import ig3.iscae.roles.Administrateur;

public class Memoire {

	private static Administrateur admin=new Administrateur("admin","admin");// Etape 1 un seul admin par defaut a changer
//	private static Map<String,String> directeurs=new HashMap<>();
	
	

	public static Administrateur getAdmin() {
		return admin;
	}

	public static void setAdmin(Administrateur admin) {
		Memoire.admin = admin;
	}
}
