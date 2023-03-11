package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
	
	private PasswordEncoder encoder ; 
	
	public WebSecurityConfig(PasswordEncoder pe) {
		this.encoder = pe ; 
	}
	
	@Bean 
	UserDetailsService userDetailsService() {
		var password = encoder.encode("8080");
		var imu = new InMemoryUserDetailsManager();
		
		var u1 = User.withUsername("faiz")
				.password(password)
				.authorities("read")
				.build();
		imu.createUser(u1);
		return imu ;
	}

}
