package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public Admin findByEmailAndPassword(String email, String password);
	
}
