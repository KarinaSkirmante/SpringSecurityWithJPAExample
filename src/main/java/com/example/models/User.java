package com.example.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="User")
@Getter @Setter @NoArgsConstructor
public class User {

	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="username")
	
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String username;//the same as username
	
	@Column(name="password")
	
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String password;//the same as username
	
	@Column(name="enabled")
	private boolean enabled=true;

	@ManyToMany(mappedBy = "users", fetch=FetchType.EAGER)
	private Collection<UserAuthority> authorities;
	
	
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
		this.authorities = new ArrayList<UserAuthority>();
	}
	
	

}
