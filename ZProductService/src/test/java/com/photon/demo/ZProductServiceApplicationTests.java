package com.photon.demo;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.photon.entity.Product;
import com.photon.exception.ResourceNotFoundException;
import com.photon.repository.ProductRepository;
import com.photon.service.ProductService;

@SpringBootTest
@RunWith(SpringRunner.class)
class ZProductServiceApplicationTests {

	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductRepository productRepository;
	

	@org.junit.Test
	public void testCreateProduct() {
		Product product = new Product();
		product.setName("Test Product");
		product.setPrice(100.00);
		
		Mockito.when(productRepository.save(product)).thenReturn(product);
		
		
		Product createProduct = productService.createProduct(product);
		Assertions.assertEquals("Test Product",createProduct.getName());
	}
	
	
	@org.junit.Test
	public void testGetProductByIdNotFound() {
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.empty());
		Assertions.assertThrows(ResourceNotFoundException.class,()-> {productService.getProductById(1L);
		});
	}
	

}
