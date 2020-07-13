package com.example.services.impl;

import java.util.ArrayList;

import com.example.models.Customer;
import com.example.models.Product;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public interface ICustomerService {

	boolean register(Customer customer);
	boolean authorise(Customer customer);
	ArrayList<Product> selectAllProductsInStore();
	ArrayList<Product> selectAllProductsByCustomer(Customer customer) throws Exception;
	float calculateShoppingListValue(ArrayList<Product> boughtProducts, Customer customer);
	
}
