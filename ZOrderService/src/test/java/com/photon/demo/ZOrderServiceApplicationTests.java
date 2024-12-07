package com.photon.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.photon.dto.Product;
import com.photon.entity.Order;
import com.photon.exception.ResourceNotFoundException;
import com.photon.repository.OrderRepository;
import com.photon.service.OrderService;

@SpringBootTest
@RunWith(SpringRunner.class)
class ZOrderServiceApplicationTests {

	@Autowired
	private OrderService orderservice;
	
	@Autowired
	private OrderRepository orderRepository;
	

	private RestTemplate restTemplate;
	
	@Test
	public void testCreaterOrderwithInvalidProduct() {
		Order order =  new Order();
		order.setCustomerName("xyz");
		order.setProducts("mobile");
		
		Mockito.when(restTemplate.getForEntity(Mockito.anyString(),Mockito.eq(Product.class)))
		.thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {orderservice.createrOrder(order);});
	}
	
	
	
	
	
	

}
