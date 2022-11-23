package com.products;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return "New Product Added Sucessfully";
	}

	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{Id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("Id") Integer Id) {
		return ResponseEntity.ok(this.productService.findProductById(Id));
	}

	@PutMapping("/{Id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("Id") Integer Id) {
		Product updateUProduct = this.productService.updateProduct(Id, product);
		return new ResponseEntity<>(updateUProduct, HttpStatus.OK);
	}
	
	@DeleteMapping("/{Id}")
	public String deleteProduct( @PathVariable("Id") Integer Id) {
		productService.deleteProduct(Id);
		return "Product Deleted Sucessfully";
	}
}
