package com.app.config.security.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.app.config.security.authentication.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	

	private final String key = "secret" ; 
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		
		CustomAuthentication ca = (CustomAuthentication) authentication ;
		String headerKey = ca.getKey();
		if(key.equals(headerKey)) {
			CustomAuthentication  result = new CustomAuthentication(true , null );
			return result ; 
			
		}
		
		throw new BadCredentialsException("Bad Credentials");
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return CustomAuthentication.class.equals(authentication);
	}
	
}