package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.Customer;
import com.example.user.service.CustomerService;

@RefreshScope
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@Value("${app.owner}")
	private String owner;
	
	
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
	
	
	@GetMapping("update-credits/{id}")
	public Customer updateCustomerCredits(@PathVariable int id, long credits ) {
		return service.updateCustomerCredits(id, credits);
		
	}
	

	@GetMapping("/owner")
	public String getOwner() {
		return owner;
		
	}
	

}
