package com.samer.jwt.jwtUtils;

import java.io.Serializable;

public class JwtRequestModel implements Serializable {

	private static final long serialVersionUID = 3548537118506095290L;

	private String username;
	private String password;

	public JwtRequestModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
