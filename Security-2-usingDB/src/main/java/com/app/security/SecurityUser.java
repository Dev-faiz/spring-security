package com.app.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.model.MyUser;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class SecurityUser implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	 
	private final MyUser user ; 

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return user.getAuths()
				.stream()
				.map(SecurityAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
//		System.out.println(user.getPassword());
		return user.getPassword();
	}

	@Override
	public String getUsername() {
//		System.out.println(user.getUsername());
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
