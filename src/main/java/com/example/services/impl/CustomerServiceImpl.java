package com.example.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Customer;
import com.example.models.Product;
import com.example.repos.ICustomerRepo;
import com.example.repos.IProductRepo;


@Service
public class CustomerServiceImpl implements ICustomerService {

	
	@Autowired
	ICustomerRepo customerRepo;
	
	@Autowired
	IProductRepo productRepo;
	
	@Autowired
	IProductService productService;
	
	@Override
	public boolean register(Customer customer) {
		
		//if exists in system than false
		if(!customerRepo.existsByNameAndSurname(customer.getName(), customer.getSurname()))
		{
			//save in system
			customerRepo.save(customer);
			return true;
		}
		
		

		return false;
	}

	@Override
	public boolean authorise(Customer customer) {
		if(customerRepo.existsByNameAndSurnameAndPassword(customer.getName(), customer.getSurname(), customer.getPassword()))
		{
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<Product> selectAllProductsInStore() {
		return productService.selectAllProducts();
	}

	@Override
	public ArrayList<Product> selectAllProductsByCustomer(Customer customer) throws Exception {
		if(customerRepo.existsByNameAndSurname(customer.getName(), customer.getSurname()))
		{
			Customer temp = customerRepo.findByNameAndSurname(customer.getName(), customer.getSurname());
			ArrayList<Product> allProductByCustomer = productRepo.findByCustomer(temp);
			return allProductByCustomer;
		}
		// TODO Auto-generated method stub
		throw new Exception("Customer not found");
	}

	@Override
	public float calculateShoppingListValue(ArrayList<Product> boughtProducts, Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

}
