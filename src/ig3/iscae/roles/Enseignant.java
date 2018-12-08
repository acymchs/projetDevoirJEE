package ig3.iscae.roles;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enseignant {
	private Integer id;
    private String nom;
    private String prenom;
    private Map<Integer,Matiere>matieres=new HashMap<>();
   
public Enseignant(String nom, String password) {
	super();
	this.nom = nom;
	this.prenom = password;
	
}


public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}


public String getPrenom() {
	return prenom;
}


public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public Map<Integer, Matiere> getMatieres() {
	return matieres;
}


public void setMatieres(Map<Integer, Matiere> matieres) {
	this.matieres = matieres;
}

   
   
   

	
}
