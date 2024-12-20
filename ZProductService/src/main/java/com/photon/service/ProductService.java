package com.photon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.photon.entity.Product;
import com.photon.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found"));
	}
}
