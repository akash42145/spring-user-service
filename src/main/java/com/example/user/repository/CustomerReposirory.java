package com.example.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.model.Customer;

@Repository
public interface CustomerReposirory extends JpaRepository<Customer, Integer> {

	@Transactional
	@Modifying
	@Query("update Customer set credist = :credits where id = :id")
	public Integer updateCredits(int id, long cre);

}
