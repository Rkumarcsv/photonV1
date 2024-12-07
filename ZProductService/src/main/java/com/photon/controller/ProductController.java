package com.photon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.entity.Product;
import com.photon.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/")
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
		return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
	}

	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id){
		return productService.getProductById(id);
		
	}
}
