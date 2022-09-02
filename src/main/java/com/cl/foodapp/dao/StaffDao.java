package com.cl.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.Staff;
import com.cl.foodapp.repository.StaffRepository;

@Repository
public class StaffDao {
	
	@Autowired
	private StaffRepository staffRepository;
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	public Optional<Staff> getby(int id){
		return staffRepository.findById(id);
	}
	public Staff delete(int id) {
		Staff staff=getby(id).get();
		staffRepository.delete(staff);
		return staff;
	}
	public Staff update(Staff staff,int id) {
		staff.setId(id);
		return staffRepository.save(staff);
	}
	public List<Staff> getall(){
		return staffRepository.findAll();
	}
	public Staff findbyEmailnPassword(Staff staff) throws Exception {
		String email=staff.getEmail();
		String password=staff.getPassword();
		Staff obj=null;
		if(email!=null && password!=null) {
			obj=staffRepository.findByEmailAndPassword(email, password);
		}
		if(obj==null) {
			throw new Exception("invalid");
		}
		return obj;
	}
		
}
