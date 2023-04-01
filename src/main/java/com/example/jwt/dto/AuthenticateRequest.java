package com.example.jwt.dto;

import java.io.Serializable;

public class AuthenticateRequest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;	
	
	@Override
	public String toString() {
		return "AuthenticateRequest [userName=" + userName + ", password=" + password + "]";
	}

	public AuthenticateRequest() {
	}

	public AuthenticateRequest(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
