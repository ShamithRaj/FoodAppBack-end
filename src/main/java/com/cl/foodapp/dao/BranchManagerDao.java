package com.cl.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.BranchManager;
import com.cl.foodapp.repository.BranchManagerRepository;

@Repository
public class BranchManagerDao {
	
	@Autowired
	private BranchManagerRepository branchManagerRepository;
	public BranchManager saveManager(BranchManager manager) {
		return branchManagerRepository.save(manager);
	}
	public Optional<BranchManager> getby(int id){
		return branchManagerRepository.findById(id);
	}
	public BranchManager delete(int id) {
		BranchManager manager=getby(id).get();
		branchManagerRepository.delete(manager);
		return manager;
	}
	public BranchManager update(BranchManager manager, int id) {
		manager.setId(id);
		return branchManagerRepository.save(manager);
	}
	public List<BranchManager> getall(){
		return branchManagerRepository.findAll();
	}
	public BranchManager findByEmailAndPassword(BranchManager manager) throws Exception {
		String email=manager.getEmail();
		String password=manager.getPassword();
		BranchManager obj=null;
		if(email!=null && password!=null) {
			obj=branchManagerRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("Enter Valid Credentials");
		}
		return obj;
	}
	
}
