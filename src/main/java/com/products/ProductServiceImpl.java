package com.products;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl {
	
	@Autowired
	private ProductRepo repo;
	
	public void addProduct(Product product) {
		repo.save(product);
	}
	
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		repo.findAll().forEach(products::add);
		return products;
	}
	
	public Optional<Product> findProductById(Integer id) {
		return repo.findById(id);
	}
	
	public Product updateProduct(Integer id, Product product) {
		product.setId(id);
		return repo.save(product);
	}
	
	public void deleteProduct(Integer id) {
		 repo.deleteById(id);
		
	}

}
