package ig3.iscae.roles;

public class Crenaux {
	private String jour;
  private String debut;
  private String fin;
  private Matiere matiere;
 
  
  
public Matiere getMatiere() {
	return matiere;
}


public void setMatiere(Matiere matiere) {
	this.matiere = matiere;
}


public Crenaux() {
	super();
	// TODO Auto-generated constructor stub
}


public Crenaux(String jour,String debut, String fin) {
	super();
	this.jour=jour;
	this.debut = debut;
	this.fin = fin;
}


public String getJour() {
	return jour;
}


public void setJour(String jour) {
	this.jour = jour;
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







  
}
