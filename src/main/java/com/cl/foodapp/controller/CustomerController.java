package com.cl.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.foodapp.entity.Customer;
import com.cl.foodapp.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer/{id}")
	public Customer saveCustomer(@RequestBody Customer customer,@PathVariable int id) {
		return customerService.saveCustomer(customer,id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/mail/{id}")
	public String send(@RequestBody Customer customer,@PathVariable int id) {
		return customerService.sendMessage(customer, id);
	}
}
