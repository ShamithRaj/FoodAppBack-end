package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.BranchManager;

public interface BranchManagerRepository extends JpaRepository<BranchManager, Integer> {

	public BranchManager findByEmailAndPassword(String email, String password);

}
