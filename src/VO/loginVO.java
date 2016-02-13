package VO;

import java.io.Serializable;

public class loginVO implements Serializable{
	private int loginid;
	private String email,password;
    private String UserType;
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	
	}

}
