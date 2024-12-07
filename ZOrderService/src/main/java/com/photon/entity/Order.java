package com.photon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotNull(message = "Product name is mandatory")
	private String customerName;
	
	@Positive(message = "Must have more then one order")
	private String products;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public Order(Long id, @NotNull(message = "Product name is mandatory") String customerName,
			@Positive(message = "Must have more then one order") String products) {
		super();
		Id = id;
		this.customerName = customerName;
		this.products = products;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [Id=" + Id + ", customerName=" + customerName + ", products=" + products + "]";
	}
	

}
