package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Integer> {

	public Staff findByEmailAndPassword(String email, String password);

}
