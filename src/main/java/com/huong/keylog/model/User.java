package com.huong.keylog.model;

import javax.validation.constraints.NotEmpty;

public class User {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String pass;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
