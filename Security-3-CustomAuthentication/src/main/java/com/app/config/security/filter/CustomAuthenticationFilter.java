package com.app.config.security.filter;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.config.security.authentication.CustomAuthentication;
import com.app.config.security.managers.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;



@Component @AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {
	

	private final CustomAuthenticationManager customAuthenticationManager ; 

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// we can create an authentication object here which is not yet authenticated 
		// delegate the authentication manager to object
		// get back the authentication from the manager 
		// if object authenticated then send request to next filter
		String key = String.valueOf(request.getHeader("key"));
		
		CustomAuthentication cam = new CustomAuthentication(false , key );
		
		
		var authencation = customAuthenticationManager.authenticate(cam);
		
		if(authencation.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(authencation);
			doFilter(request, response, filterChain);
		}
		
	
		
	}

	

}
