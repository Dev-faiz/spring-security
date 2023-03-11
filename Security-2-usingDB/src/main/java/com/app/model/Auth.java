package com.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @NoArgsConstructor 
@AllArgsConstructor @Setter @Getter
public class Auth {

	@Id
	private Integer id ; 
	
	private String auth ; 
	
	@ManyToMany(mappedBy = "auths")
	private Set<MyUser> myUsers ;
	
}
