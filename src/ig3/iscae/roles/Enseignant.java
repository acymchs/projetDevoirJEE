package ig3.iscae.roles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Enseignant {
	private Integer id;
    private String nom;
    private String prenom;
    private Map<String,Matiere>matieres=new HashMap<>();
   
public Enseignant(String nom, String password) {
	super();
	this.nom = nom;
	this.prenom = password;
	
}


public Enseignant() {
	// TODO Auto-generated constructor stub
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


public List<Matiere> getMatieres() {
	return new ArrayList<Matiere>(matieres.values());
}


public void setMatieres(Matiere matiere) {
	this.matieres.put(matiere.getNom(), matiere);
}



















   
   
   

	
}
