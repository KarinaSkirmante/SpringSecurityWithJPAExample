package com.example.models;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="UserAuthority")
@Getter @Setter @NoArgsConstructor
public class UserAuthority {
	
	@Column(name="aid")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int aid;
	@Column(name="authority")
	private String authority;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "user_authorities", 
			  joinColumns = @JoinColumn(name = "a_id"), 
			  inverseJoinColumns = @JoinColumn(name = "id"))
	private Collection<User> users;

	public UserAuthority(Collection<User> users) {
		super();
		this.users = users;
	}

	public UserAuthority(String authority, Collection<User> users) {
		super();
		this.authority = authority;
		this.users = users;
	}

	public UserAuthority(String authority) {
		super();
		users = new ArrayList<User>();
		this.authority = authority;
	}

	public void setUser(User user)
	{
		users.add(user);
	}

	
	
}
