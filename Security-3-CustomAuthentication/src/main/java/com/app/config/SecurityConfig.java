package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.app.config.security.filter.CustomAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private final CustomAuthenticationFilter customAuthenticationFilter ;
	
	public SecurityConfig(CustomAuthenticationFilter caf) {
		this.customAuthenticationFilter = caf ;
	}
	
	@Bean
	SecurityFilterChain filterChain( HttpSecurity http) throws Exception {
		
		
		return http
				.addFilterAt( customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.authorizeHttpRequests().anyRequest().authenticated()
				.and()
				.build();
	}

}
