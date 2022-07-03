package com.example.user.http.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient("spring-product-service")
public interface ProductClient {

	@GetMapping("/product/{id}")
	String getProduct(@PathVariable int id);

}
