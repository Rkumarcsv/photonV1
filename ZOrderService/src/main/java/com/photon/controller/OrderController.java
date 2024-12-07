package com.photon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photon.entity.Order;
import com.photon.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/")
	public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order){
		return new ResponseEntity<>(orderService.createrOrder(order), HttpStatus.CREATED);
	}

}
