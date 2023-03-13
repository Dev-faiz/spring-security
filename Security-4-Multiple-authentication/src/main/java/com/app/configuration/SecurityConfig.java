package com.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.app.configuration.filter.ApiKeyFilter;

@Configuration
public class SecurityConfig {
	
//	@Value("${the.secret}")
	private String key = "secret" ;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.httpBasic()
				.and()
				.addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
				.authorizeHttpRequests().anyRequest().authenticated().and()
				.build();
	}

}
