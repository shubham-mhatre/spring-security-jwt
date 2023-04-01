package com.example.jwt.dto;

import java.io.Serializable;

public class AuthenticateResponse implements Serializable{

	private static final long serialVersionUID = -6500280606751276318L;
	
	private String token;
	private String message;

	public AuthenticateResponse() {
	}

	public AuthenticateResponse(String token,String message) {
		super();
		this.token = token;
		this.message=message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AuthenticateResponse [token=" + token + ", message=" + message + "]";
	}

	

}
