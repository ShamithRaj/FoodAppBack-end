package com.cl.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.foodapp.dao.StaffDao;
import com.cl.foodapp.entity.Staff;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class StaffServices {
	
	@Autowired
	StaffDao staffDao;
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(Staff staff){
		ResponseStructure<Staff> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Staff has been saved");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(staffDao.saveStaff(staff));
		return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.CREATED); }
	public ResponseEntity<ResponseStructure<Staff>> getby(int id){
		Optional<Staff> staff=staffDao.getby(id);
		ResponseStructure<Staff> responseStructure=new ResponseStructure<>();
		if(staff.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("Staff has been found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(staff.get());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK); }}
	
	public ResponseEntity<ResponseStructure<Staff>> delete(int id){
		Optional<Staff> staff=staffDao.getby(id);
		ResponseStructure<Staff> responseStructure=new ResponseStructure<>();
		if(staff.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("Staff has been deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(staffDao.delete(id));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK); }}
	public ResponseEntity<ResponseStructure<Staff>> update(Staff staff,int id){
		Optional<Staff> staff2=staffDao.getby(id);
		ResponseStructure<Staff> responseStructure=new ResponseStructure<>();
		if(staff2.isEmpty()) {
			responseStructure.setMessage("ID not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("Staff has been Updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(staffDao.update(staff, id));
			return new ResponseEntity<ResponseStructure<Staff>>(responseStructure,HttpStatus.OK); }}
	public ResponseEntity<ResponseStructure<List<Staff>>> getall(){
		ResponseStructure<List<Staff>> responseStructure=new ResponseStructure<List<Staff>>();
		responseStructure.setMessage("Staffs have been found");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(staffDao.getall());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(responseStructure,HttpStatus.OK);}
	public Staff findbyEmailnPassword(Staff staff) throws Exception {
		return staffDao.findbyEmailnPassword(staff);
	}}
