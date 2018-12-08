package ig3.iscae.roles;

public class Crenaux {
  private String debut;
  private String fin;
  private Matiere matiere;
  
  
public Crenaux() {
	super();
	// TODO Auto-generated constructor stub
}


public Crenaux(String debut, String fin) {
	super();
	this.debut = debut;
	this.fin = fin;
}


public String getDebut() {
	return debut;
}
public void setDebut(String debut) {
	this.debut = debut;
}
public String getFin() {
	return fin;
}
public void setFin(String fin) {
	this.fin = fin;
}
public Matiere getMatiere() {
	return matiere;
}
public void setMatiere(Matiere matiere) {
	this.matiere = matiere;
}
  
  
}
