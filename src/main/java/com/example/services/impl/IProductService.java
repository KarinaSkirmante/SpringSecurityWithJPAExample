package com.example.services.impl;

import java.util.ArrayList;

import com.example.models.Product;


public interface IProductService {
	
	void inputData();
	//CRUD - create, read, update, delete
	
	//CREATE
	//izveidot, ja padod objekta referenci
	boolean insertNewProductByObject(Product product);
	//izveidot, ja padod katru paramatru atsevišķi
	boolean insertNewProductByParams(String title, int quantity, float price, String description);
		
	
	//READ
	//sameklēt vienu produktu sarakstā pēc tā id
	Product selectOneProductById(int id) throws Exception;
	
	//atgriež visus produktus, kas veikalā
	ArrayList<Product> selectAllProducts();
	
	
	//UPDATE
	//redigejam pēc objekta references
	boolean updateByObject(Product product);
	//redigejam pēc objekta parametriem
	boolean updateByParams(/*neredigejams*/String title,  int quantity, float price, String description);
	
	//DELETE
	//izdzēšam produktu no saraksta, sameklējot to pēc id
	boolean deleteById(int id);
	
	boolean deleteByTitle(String title);
	
	
	//Funkcionālā daļa
	boolean changeProductQuantity(String title, int newQuantity);
	
	//etc
	
	
	
	
	

}
