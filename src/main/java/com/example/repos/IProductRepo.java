package com.example.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.models.Customer;
import com.example.models.Product;


public interface IProductRepo extends CrudRepository<Product, Integer>{
	
	//SELECT * FROM PRODUCT WHERE Title = title
	Product findByTitle(String title);
	
	Product findByTitleAndPrice(String title, float price);
	
	Product findByPriceLessThan(float price);
	
	boolean existsByTitle(String title);

	ArrayList<Product> findByCustomer(Customer temp);
	
	
	//@Query(value="")
	//Product findBysdakdhalsd();
	

}
