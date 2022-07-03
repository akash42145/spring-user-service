package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user.model.Customer;

@Repository
public interface CustomerReposirory extends JpaRepository<Customer, Integer> {

}
