package com.example.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.exception.CustomerNotFoundException;
import com.example.user.exception.NotEnoughCreditsException;
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

	public Customer updateCustomerCredits(int id, double credits) {
		Customer c = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("No Customer is not found for this id: "+ id));
		double availableCredits = c.getCredits();
		
		if(availableCredits < credits) {
			throw new NotEnoughCreditsException("Not Enough Credits, Available: "+ availableCredits + ", Required Credits: "+ credits);
		}

		 repository.updateCredits(id, availableCredits - credits);

		return c;
	}
	

}
