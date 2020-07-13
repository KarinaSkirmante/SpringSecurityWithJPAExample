package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="ProductTable")

public class Product {
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="P_Id")
	private int p_id;
	//private static int idCounter = 0;
	
	
	@Column(name="Title")
	@Size(min=3, max=30)
	@Pattern(regexp="[a-zA-Z\\s]+$")
	private String title;
	
	
	@Column(name="Quantity")
	@Min(value = 1)
	@Max(value = 2000)
	private int quantity;
	
	
	@Column(name="Price")
	@Min(value = 0)
	@Max(value = 1000)
	private float price;
	
	@Column(name="Description")
	@Size(min=5, max=100)
	private String description;
	
	@Column(name="Type")
	private ProductType type;
	
	//many products have the same customer
	@ManyToOne
	//customer id will be store in product record - join by id column from Customer
	@JoinColumn(name="C_Id")
	private Customer customer;
	
	
	
	
	
	
	
	
	
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product(@Size(min = 3, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$") String title,
			@Min(1) @Max(2000) int quantity, @Min(0) @Max(1000) float price,
			@Size(min = 5, max = 100) String description, Customer customer) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.customer = customer;
	}

	public Product()
	{
		
	}

	public Product(String title, int quantity, float price, String description) {
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
	//	this.id = idCounter;
	//	idCounter++;
	}

	
	
	public Product(@Size(min = 3, max = 30) @Pattern(regexp = "[a-zA-Z\\s]+$") String title,
			@Min(1) @Max(2000) int quantity, @Min(0) @Max(1000) float price,
			@Size(min = 5, max = 100) String description, ProductType type) {
		super();
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.type = type;
	}

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return p_id;
	}

	@Override
	public String toString() {
		return "Product [id=" + p_id + ", title=" + title + ", quantity=" + quantity + ", price=" + price
				+ ", description=" + description + "]" + type;
	}
	
	
	
	

}
