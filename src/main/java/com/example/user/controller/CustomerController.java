package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.http.client.ProductClient;
import com.example.user.model.Customer;
import com.example.user.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Autowired
	private ProductClient productClient;
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
		
	}
	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return service.getCustomer(id);
		
	}
	
	@GetMapping
	public List<Customer> getAllCustomer() {
		return service.getAllCustomer();
		
	}
	
	@GetMapping("/product/{id}")
	public String getProduct(@PathVariable int id) {
		return productClient.getProduct(id);
		
	}
	

}
