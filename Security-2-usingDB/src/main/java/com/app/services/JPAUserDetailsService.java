package com.app.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.model.MyUser;
import com.app.repo.MyUserRepo;
import com.app.security.SecurityUser;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class JPAUserDetailsService implements UserDetailsService {
	
	private final MyUserRepo myUserRepo ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<MyUser> user = myUserRepo.findMyUserByUsername(username);
//		System.out.println(user.get().getUsername());
//		System.out.println(user.get().getPassword());
		return user.map(SecurityUser::new)
					.orElseThrow(()-> new UsernameNotFoundException("User not found "+username));
	}
 
}
