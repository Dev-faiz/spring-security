package com.app.security;

import org.springframework.security.core.GrantedAuthority;

import com.app.model.Auth;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
	
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private final Auth auth ;

	@Override
	public String getAuthority() {
		System.out.println(auth.getAuth());
		return auth.getAuth();
	}

}
