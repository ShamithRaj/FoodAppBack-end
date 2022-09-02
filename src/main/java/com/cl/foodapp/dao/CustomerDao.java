package com.cl.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.Customer;
import com.cl.foodapp.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository customerRepository;
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	

}
