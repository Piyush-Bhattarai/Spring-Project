package com.springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springproject.model.Product;
import com.springproject.repository.ProductRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "Product REST API", version ="4.0", description = "Product data load"))

public class ProductRestController {
	
	@Autowired
	private ProductRepository prepo;
	
	
	@GetMapping("/product/load")
	public String loadProducts() {
		
		RestTemplate temp = new RestTemplate();
		
	    Product[] products	= temp.getForObject("https://fakestoreapi.com/products", Product[].class);
		
	    prepo.saveAll(List.of(products));
	    
		return "success";
	}
	

}
