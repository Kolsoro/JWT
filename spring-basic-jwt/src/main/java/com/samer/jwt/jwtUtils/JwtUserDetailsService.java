package com.samer.jwt.jwtUtils;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if(username.equals("samer")) {
			return new User("samer", 
					"$2a$12$785IwwWaOiTxn8j6Ld0lrOJsXdfO/gyoqgPys.itoNP.J1.jVOx3q",
					new ArrayList<>());
		}else {
			throw new UsernameNotFoundException(String.format("Username :%s , not found",username));
		}
		
	}

}
