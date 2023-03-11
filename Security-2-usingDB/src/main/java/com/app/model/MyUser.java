package com.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyUser {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	
	private String username ; 
	
	private String password ; 
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_auth" ,
			   joinColumns = @JoinColumn( name = "user_id"  ) ,
			   inverseJoinColumns = @JoinColumn(name = "auth_id")
			)
	private Set<Auth> auths ;
}
