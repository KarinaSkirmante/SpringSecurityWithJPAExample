package com.example.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.models.Customer;
import com.example.models.Product;
import com.example.models.User;
import com.example.repos.ICustomerRepo;
import com.example.repos.IProductRepo;
import com.example.repos.UserAuthorityRepo;
import com.example.repos.UserRepo;


@Primary
@Service
public class ProductServiceImpl2 implements IProductService {

	@Autowired
	IProductRepo productRepo;
	
	@Autowired
	ICustomerRepo customerRepo;
	
	@Autowired
	UserRepo userRepo;
	
	 @Autowired
	    PasswordEncoder passwordEncoder;
	 
	 @Autowired
	UserAuthorityRepo userAuthRepo;
	
	@Override
	public boolean insertNewProductByObject(Product product) {
		
		if(productRepo.existsByTitle(product.getTitle()))
		{
			return false;
		}
		
		else
		{
			productRepo.save(product);
			return true;
		}
		
		
		
	}

	@Override
	public boolean insertNewProductByParams(String title, int quantity, float price, String description) {
		
		if(productRepo.existsByTitle(title))
		{
			return false;
		}
		
		Product newProduct = new Product(title, quantity, price, description);
		productRepo.save(newProduct);
		return true;
	}

	@Override
	public Product selectOneProductById(int id) throws Exception {
		
		Product selectedProduct = productRepo.findById(id).get();

		if(selectedProduct!=null)
		{
			return selectedProduct;
		}
		
		
		throw new Exception("id is wrong");
	}

	@Override
	public ArrayList<Product> selectAllProducts() {
		return (ArrayList<Product>) productRepo.findAll();
	}

	@Override
	public boolean updateByObject(Product product) {//id padodatjama ir 0, tāpēc pēc ta nevar meklēt
		//find if product exists
		if(productRepo.existsByTitle(product.getTitle()))
		{
			//get product from DB with the right id number
			Product temp = productRepo.findByTitle(product.getTitle());
			//update product in System
			temp.setDescription(product.getDescription());
			temp.setPrice(product.getPrice());
			temp.setQuantity(product.getQuantity());
			//save updated product in DB
			productRepo.save(temp);
			return true;
		}
		
		
		
		return false;

	}

	@Override
	public boolean updateByParams(String title, int quantity, float price, String description) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		
		if(productRepo.existsById(id))
		{
			productRepo.deleteById(id);
			return true;
		}
		
	
		return false;
	}

	@Override
	public boolean deleteByTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeProductQuantity(String title, int newQuantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inputData() {
		
		Customer c1 = new Customer("Janis",  "Berzins", "12345678");
		
		Customer c2 = new Customer("Baiba", "Jauka", "34567890");
		customerRepo.save(c1);
		customerRepo.save(c2);
		
		Product p1 = new Product("Abols", 4, 0.30f, "Garšīgi");
		p1.setCustomer(c1);
		productRepo.save(p1);
		
		
		productRepo.save(new Product("Galds", 1, 30.99f, "No koka", c2));
		productRepo.save(new Product("Dators", 10, 500.99f, "Dellfdfd"));
		
		
		userAuthRepo.save(new com.example.models.UserAuthority("ADMIN"));
    	userAuthRepo.save(new com.example.models.UserAuthority("USER"));
		
		 String encodedPassword  = passwordEncoder.encode("123");
	    User u = new User("karina", encodedPassword);
	    com.example.models.UserAuthority boardAuthority = userAuthRepo.findByAuthority("ADMIN");
	       // boardAuthority.setAuthority("BOARD");
	   // u.getAuthorities().add(boardAuthority);    
	        
	    boardAuthority.setUser(u);
		userRepo.save(u);
		
		String encodedPassword2  = passwordEncoder.encode("321");
	    User u2 = new User("janis", encodedPassword);
	    com.example.models.UserAuthority boardAuthority2 = userAuthRepo.findByAuthority("USER");
	       // boardAuthority.setAuthority("BOARD");
	   // u.getAuthorities().add(boardAuthority);    
	        
	    boardAuthority2.setUser(u2);
		userRepo.save(u2);
		
	}

}
