package ig3.iscae.roles;

public class Matiere {
	private Integer id;
    private String nom;
    private Enseignant enseignant;
    
    
    
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Matiere(String nom) {
		super();
		
		this.nom = nom;
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
	public Enseignant getEnseignant() {
		return enseignant;
	}
	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
    
  
}
