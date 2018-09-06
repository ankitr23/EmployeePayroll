package Admin;

import Model.Database;

public class AdminLogin {

	private String adminId;
	private String password;
	public AdminLogin()
	{
		
	}
	public AdminLogin(String adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
