package com.cl.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.Branch;
import com.cl.foodapp.repository.BranchRepository;

@Repository
public class BranchDao {
	
	@Autowired
	BranchRepository branchRepository;
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}
	public Optional<Branch> getby(int id) {
		return branchRepository.findById(id);
	}
	public Branch delete(int id) {
		Branch branch=getby(id).get();
		branchRepository.delete(branch);
		return branch;
	}
	public Branch update(Branch branch,int id) {
		branch.setId(id);
		return branchRepository.save(branch);
	}
	public List<Branch> getall() {
		// TODO Auto-generated method stub
		return branchRepository.findAll();
	}
}
