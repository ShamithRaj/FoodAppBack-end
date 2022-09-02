package com.cl.foodapp.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.Admin;
import com.cl.foodapp.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	AdminRepository adminRepository;
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	public Optional<Admin> getby(int id) {
		return adminRepository.findById(id);
	}
	public Admin delete(int id) {
		Admin admin=getby(id).get();
		adminRepository.delete(admin);
		return admin;
	}
	public Admin updatAdmin(Admin admin,int id) {
			admin.setId(id);
			return adminRepository.save(admin);
		}
	public List<Admin> getall(){
		return adminRepository.findAll();
	}
	public String getRole(int id) {
		String admin=getby(id).get().getRole();
		return admin;
	}
	public Admin findbyEmailnPassword(Admin admin) throws Exception {
		String email=admin.getEmail();
		String password=admin.getPassword();
		Admin obj=null;
		if(email!=null && password!=null) {
			obj=adminRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("invalid");
		}
		return obj;
	}
	
	
	
}
