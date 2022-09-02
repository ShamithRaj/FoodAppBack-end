package com.cl.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.foodapp.entity.Staff;

import com.cl.foodapp.service.StaffServices;
import com.cl.foodapp.responseStructure.ResponseStructure;

@RestController
public class StaffController {
	
	@Autowired
	StaffServices staffServices;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/staff")
	public ResponseEntity<ResponseStructure<Staff>> saveManager(@RequestBody Staff staff){
		return staffServices.saveStaff(staff);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getstaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> getby(@PathVariable int id){
		return staffServices.getby(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletestaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> delete(@PathVariable int id){
		return staffServices.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updatestaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> update(@RequestBody Staff staff,@PathVariable int id){
		return staffServices.update(staff,id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getallstaff")
	public ResponseEntity<ResponseStructure<List<Staff>>> getall(){
		return staffServices.getall();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getbystaff")
	public Staff get(@RequestBody Staff staff) throws Exception {
		return staffServices.findbyEmailnPassword(staff);
	}

}
