package ig3.iscae.roles;

public class DirecteurEtude{

	
	private String loginDE;
	private String passwordDE;
	
	
	public DirecteurEtude(String loginDE, String passwordDE) {
		super();
		this.loginDE = loginDE;
		this.passwordDE = passwordDE;
	}
	public DirecteurEtude() {
		// TODO Auto-generated constructor stub
	}
	public String getLoginDE() {
		return loginDE;
	}
	public void setLoginDE(String loginDE) {
		this.loginDE = loginDE;
	}
	public String getPasswordDE() {
		return passwordDE;
	}
	public void setPasswordDE(String passwordDE) {
		this.passwordDE = passwordDE;
	}
	
	
}
