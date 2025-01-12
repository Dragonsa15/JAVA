package com.adobe.prj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adobe.prj.entity.Product;
import com.adobe.prj.service.OrderService;

@RestController
@RequestMapping("api/products")
public class ProductController {
	@Autowired
	private OrderService service;

	// http://localhost:8080/api/products
	// returned List<Product> is given to HttpMessageConverter based on Accept header
	@GetMapping
	public List<Product> getProducts() {
		return service.getProducts();
	}
	
	// http://localhost:8080/api/products/3
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return service.getProductById(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable("id") int id, @RequestBody Product p) {
		service.updateProduct(id, p);
		return service.getProductById(id);
	}
}
