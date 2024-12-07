package com.photon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.photon.dto.Product;
import com.photon.entity.Order;
import com.photon.exception.ResourceNotFoundException;
import com.photon.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Order createrOrder(Order order) {
		String ProducyServiceUrl = "http://localhost:8080/v1/api/products"+ order.getProducts();
		ResponseEntity<Product> response  = restTemplate.getForEntity(ProducyServiceUrl, Product.class);
		if(!response.getStatusCode().is2xxSuccessful()) {
			throw new ResourceNotFoundException("Product not found");
		}
		return orderRepository.save(order);
	}
	
	

}
