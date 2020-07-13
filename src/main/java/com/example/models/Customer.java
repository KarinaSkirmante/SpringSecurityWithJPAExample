package com.example.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="CustomerTable")
public class Customer {
	
	@Column(name="C_Id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int c_id;
	
	@Column(name="Name")
	@Size(min=4, max=30)
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String name;//the same as username
	
	@Column(name="Surname")
	@Size(min=4, max=30)
	//@Pattern(regexp="[a-zA-Z\\s]+$")
	private String surname;//the same as username
	
	@Column(name = "Password")
	//@Pattern(regexp="[a-zA-Z0-9] {8}")
	private String password;//TODO MD5

	//one customer has many products
	@OneToMany(mappedBy="customer")//mapped by variable from Product class
	private Collection<Product> allProducts;
	
		
	public Collection<Product> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(Collection<Product> allProducts) {
		this.allProducts = allProducts;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getC_id() {
		return c_id;
	}

	
	
	public Customer(@Size(min = 4, max = 30) String name, @Size(min = 4, max = 30) String surname, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
	}

	public Customer()
	{
		
	}

	@Override
	public String toString() {
		return "Customer [c_id=" + c_id + ", nameAndSurname=" + name + " " +surname + ", password=" + password + "]";
	}
	
	
	
}
