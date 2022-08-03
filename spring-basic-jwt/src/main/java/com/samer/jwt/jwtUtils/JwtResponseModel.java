package com.samer.jwt.jwtUtils;

import java.io.Serializable;

public class JwtResponseModel implements Serializable{

	private static final long serialVersionUID = -3825539770013230756L;
	
	private String token;

	public JwtResponseModel(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	
	

}
