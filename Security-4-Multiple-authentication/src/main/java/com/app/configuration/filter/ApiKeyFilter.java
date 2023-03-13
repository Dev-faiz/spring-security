package com.app.configuration.filter;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.app.configuration.authentication.ApiKeyAuthentication;
import com.app.configuration.manager.CustomAuthenticationManager;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor @Slf4j
public class ApiKeyFilter extends OncePerRequestFilter  {
	
	private final String key ;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)  throws ServletException, IOException {
		
		CustomAuthenticationManager authenticationManager = new CustomAuthenticationManager(key);
		
		var requestKey = request.getHeader("api-key");
		
		
		if("null".equals(requestKey) || requestKey == null ) filterChain.doFilter(request, response);
		
		var auth = new ApiKeyAuthentication(requestKey);
		
		try {
			var authentication = authenticationManager.authenticate(auth);
			if(authentication.isAuthenticated()) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
				log.info(requestKey);
				filterChain.doFilter(request, response);
			}else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
			
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		}
		
	}

}
