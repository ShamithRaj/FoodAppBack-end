package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.Branch;

public interface BranchRepository extends JpaRepository<Branch, Integer> {

}
