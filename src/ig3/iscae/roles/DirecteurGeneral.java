package ig3.iscae.roles;

public class DirecteurGeneral {
   private String loginDG; //DG pour directeur General et DE pour directeur d'Etudes!
   private String passwordDG;
   
   
   
public DirecteurGeneral(String loginDG, String passwordDG) {
	super();
	this.loginDG = loginDG;
	this.passwordDG = passwordDG;
}
public DirecteurGeneral() {
	// TODO Auto-generated constructor stub
}
public String getLoginDG() {
	return loginDG;
}
public void setLoginDG(String loginDG) {
	this.loginDG = loginDG;
}
public String getPasswordDG() {
	return passwordDG;
}
public void setPasswordDG(String passwordDG) {
	this.passwordDG = passwordDG;
}
   
   
}
