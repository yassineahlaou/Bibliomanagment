package authentification;

import java.io.Serializable;

public class Login implements Serializable {
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String username, String password, boolean st) {
		super();
		this.username = username;
		this.password = password;
		this.st = st;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSt() {
		return st;
	}
	public void setSt(boolean st) {
		this.st = st;
	}
	private String  username;
	private String password;
	private boolean st;

}
