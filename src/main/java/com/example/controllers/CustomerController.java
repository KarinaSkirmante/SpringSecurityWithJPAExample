package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.models.Product;
import com.example.models.Customer;
import com.example.services.impl.IProductService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	IProductService productService;
	
	
	@GetMapping("/buy")
	public String getBuy(Model model, Customer customer)
	{
		model.addAttribute("allProducts", productService.selectAllProducts());
		return "customer-buy";
	}
	
	@PostMapping("/buy")
	public String postBuy(Model model, Customer customer)
	{
		System.out.println("!!!!");
		System.out.println(customer.getName());
		
		for(Product p: customer.getAllProducts())
			System.out.println(p);
		return "redirect:/product/selectall";
	}
}
