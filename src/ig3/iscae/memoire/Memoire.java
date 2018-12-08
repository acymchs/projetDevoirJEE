package ig3.iscae.memoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ig3.iscae.roles.Administrateur;
import ig3.iscae.roles.Crenaux;
import ig3.iscae.roles.DirecteurEtude;
import ig3.iscae.roles.DirecteurGeneral;
import ig3.iscae.roles.Enseignant;
import ig3.iscae.roles.Matiere;

public class Memoire {

	private static Administrateur admin=new Administrateur("admin","admin");// Etape 1 un seul admin par defaut a changer
    private static DirecteurGeneral directeurG=new DirecteurGeneral();
    private static DirecteurEtude directeurE=new DirecteurEtude();
    private static Map<Integer,Enseignant> enseignants=new HashMap<>();
    private static Map<Integer,Matiere>matieres=new HashMap<>();
    private static Crenaux crenaux=new Crenaux();

//	#####################################################################
//getters et setters de l'administarteur
	public static Administrateur getAdmin() {
		return admin;
	}

	public static void setAdmin(Administrateur admin) {
		Memoire.admin = admin;
	}
	
	
	//#########################################################
	//getters et setters des directeurs genenrales
	public static DirecteurGeneral getDirecteurG() {
		return directeurG;
	}

	public static void setDirecteurG(DirecteurGeneral directeurG) {
		Memoire.directeurG = directeurG;
	}
	
	
//	#########################################################
	//getters et setters des directeurs etude
	public static DirecteurEtude getDirecteurE() {
		return directeurE;
	}

	public static void setDirecteurE(DirecteurEtude directeurE) {
		Memoire.directeurE = directeurE;
	}

	

	
//#########################################################3
	//getters et setters des enseignants
	public static Map<Integer, Enseignant> getEnseignants() {
		return enseignants;
	}

	public static void setEnseignants(Map<Integer, Enseignant> enseignants) {
		Memoire.enseignants = enseignants;
	}

	//#########################################################
	//getters and setters des matieres
	public static Map<Integer, Matiere> getMatieres() {
		return matieres;
	}

	public static void setMatieres(Map<Integer, Matiere> matieres) {
		Memoire.matieres = matieres;
	}
	//#########################################################
		//getters and setters des crenaux

	public static Crenaux getCrenaux() {
		return crenaux;
	}

	public static void setCrenaux(Crenaux crenaux) {
		Memoire.crenaux = crenaux;
	}
	
	
	
	
	
	
}
