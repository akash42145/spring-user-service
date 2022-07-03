package com.example.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.model.Customer;
import com.example.user.repository.CustomerReposirory;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerReposirory repository;

	public Customer addCustomer(Customer customer) {		
		return repository.save(customer);
	}

	public Customer getCustomer(int id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException());
	}

	public List<Customer> getAllCustomer() {		
		return repository.findAll();
	}
	

}
