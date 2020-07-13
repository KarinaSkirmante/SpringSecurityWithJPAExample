package com.example.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.models.Product;
import com.example.services.impl.ProductServiceImpl2;


@Controller
@RequestMapping("/product") //localhost:8080/product/
public class ProductController {
	
	@Autowired
	ProductServiceImpl2 productServiceImpl;
	
	//ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	
	@GetMapping("/inputdata")//localhost:8080/product/inputdata
	public String callInputDataService()
	{
		productServiceImpl.inputData();
		return "hello";//hello.html
	}
	
	@GetMapping("/selectall")//localhost:8080/product/selectall
	public String showAllProducts(Model model)
	{
		model.addAttribute("innerObj", productServiceImpl.selectAllProducts());
		return "all-products-show";//all-products-show.html
	}
	
	@GetMapping("/selectall/{id}")//localhost:8080/product/selectall/3
	public String showOneProductById(Model model, @PathVariable(name="id") int id)
	{
		try {
			model.addAttribute("innerObj", productServiceImpl.selectOneProductById(id));
			return "product-show";//product-show.html
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	//ievadīt jaunu produktu caur html lapu
	//1. ir parādīt lapu, kurā ir ievades lauki
	@GetMapping("/insert") //localhost:8080/product/insert
	public String insertGet(Product product)//ieejas parametrs būs tukšs objekts
	{
		return "product-insert";//product-insert.html
	}
	
	//2. pēc ievades nolasīt datus, izpildas automātiski, ja submit poga ir nospiesta formā
	@PostMapping("/insert")//localhost:8080/product/insert
	public String insertPost(@Valid Product product, BindingResult result)//ieejas parametrs būs aizpildīts objekts, ar tiem datiuem, ko ierakstīja html pusē
	{
		System.out.println(product);
		
		if(!result.hasErrors())
		{
			productServiceImpl.insertNewProductByObject(product);
			return "redirect:/product/selectall";//redirect gadījumā norādām uz url adresi (nevis html lapu)
		}
		else
			return "product-insert";
	}
	
	//redigēt produktu caur html
	//1. parādīt update lapu, bet jau ar objekta vērtībām
	@GetMapping("/update/{id}")//localhost:8080/product/update/2
	public String updateGet(@PathVariable(name="id") int id, Model model, Product product)
	{
		try {
			Product temp = productServiceImpl.selectOneProductById(id);
			model.addAttribute("product", temp);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "product-update";//product-update.html
	}
	
	//2.noalsīt lietotāja ievadītos datus html lapā
	@PostMapping("/update")
	public String updatePost(Product product)
	{
		System.out.println(product);
		if(productServiceImpl.updateByObject(product))
			return "redirect:/product/selectall";//pārlecām uz citu url adresi
		else
			return "product-update";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable(name = "id") int id, Model model)
	{
		if(productServiceImpl.deleteById(id))
		{
			model.addAttribute("innerObj", productServiceImpl.selectAllProducts());
			return "all-products-show";//all-products-show.html
		}
		
		return "error";
		
	}
	
	
	
	
	
	
	
	
	

}
