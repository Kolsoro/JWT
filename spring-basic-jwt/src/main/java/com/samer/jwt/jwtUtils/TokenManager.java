package com.samer.jwt.jwtUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class TokenManager implements Serializable {

	private static final long serialVersionUID = -6825489754963124206L;

	private static final long TOKEN_VALIDITY = 10 * 60 * 60;

	@Value("${secret}")
	private String jwtSecret;

	public String generateJwtToken(UserDetails userDetails) {

		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

	}

	public boolean validateJwtToken(String token, UserDetails userDetails) {

		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		String username = getUsernameFromToken(token);
		boolean isTokenExpired = claims.getExpiration().before(new Date());

		return (username.equals(userDetails.getUsername()) && !isTokenExpired);

	}

	public String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();

	}

}
