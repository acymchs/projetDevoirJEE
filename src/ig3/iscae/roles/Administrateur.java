package ig3.iscae.roles;

public class Administrateur {

	 private String login;
	  private String password;
	  
	public Administrateur() {
	}

	public Administrateur(String login, String password) {
		this.login = login;
		this.password = password;
	}

	//constructeur par copie pour remplacer admin par defaut par nouveau admin
	public Administrateur(Administrateur admin) {
		this.login=admin.login;
		this.password=admin.password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
