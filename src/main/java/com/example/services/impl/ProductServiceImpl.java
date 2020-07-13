package com.example.services.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.models.Product;


@Service
public class ProductServiceImpl implements IProductService {

	private ArrayList<Product> allProducts = new ArrayList<Product>();

	@Override
	public boolean insertNewProductByObject(Product product) {
		for (int i = 0; i < allProducts.size(); i++) {
			if (allProducts.get(i).getTitle().equals(product.getTitle()))
				return false;
		}
		Product newProduct = new Product(product.getTitle(), product.getQuantity(), product.getPrice(),
				product.getDescription());
		allProducts.add(newProduct);
		return true;
	}

	@Override
	public boolean insertNewProductByParams(String title, int quantity, float price, String description) {
		for (int i = 0; i < allProducts.size(); i++) {
			if (allProducts.get(i).getTitle().equals(title))
				return false;
		}
		Product newProduct = new Product(title, quantity, price, description);
		allProducts.add(newProduct);
		return true;
	}

	@Override
	public Product selectOneProductById(int id) throws Exception {
		if (id >= 0 && id < allProducts.size()) {
			for (int i = 0; i < allProducts.size(); i++) {
				if (allProducts.get(i).getId() == id) {
					return allProducts.get(i);
				}
			}
		}
		throw new Exception("id is wrong");
	}

	@Override
	public ArrayList<Product> selectAllProducts() {
		return allProducts;
	}

	@Override
	public boolean updateByObject(Product product) {
		for (int i = 0; i < allProducts.size(); i++) {
			if (allProducts.get(i).getTitle().equals(product.getTitle())) {
				allProducts.get(i).setQuantity(product.getQuantity());
				allProducts.get(i).setPrice(product.getPrice());
				allProducts.get(i).setDescription(product.getDescription());
				return true;
			}
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
		if (id >= 0) {
			for (int i = 0; i < allProducts.size(); i++) {
				if (allProducts.get(i).getId() == id) {
					allProducts.remove(i);
					return true;
				}
			}
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
		allProducts.add(new Product("Ābols", 4, 0.30f, "Garšīgi"));
		allProducts.add(new Product("Galds", 1, 30.99f, "No koka"));
		allProducts.add(new Product("Dators", 10, 500.99f, "Dell"));
		
	}

}
