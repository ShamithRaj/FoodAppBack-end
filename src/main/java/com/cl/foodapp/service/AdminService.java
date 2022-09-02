package com.cl.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.foodapp.Exception.IdNotFound;
import com.cl.foodapp.dao.AdminDao;
import com.cl.foodapp.entity.Admin;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("admin has been Saved");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(adminDao.saveAdmin(admin));
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.CREATED);}

	public ResponseEntity<ResponseStructure<Admin>> updateadmin(Admin admin, int id) {
		Optional<Admin> optional = adminDao.getby(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			responseStructure.setT(null);
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("admin got updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(adminDao.updatAdmin(admin, id));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<Admin>> getby(int id) {
		Optional<Admin> optional = adminDao.getby(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("admin has been found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<Admin>> delete(int id) {
		Optional<Admin> optional = adminDao.getby(id);
		ResponseStructure<Admin> responseStructure = new ResponseStructure<>();
		if (optional.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("admin has been deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(adminDao.delete(id));
			return new ResponseEntity<ResponseStructure<Admin>>(responseStructure, HttpStatus.OK);}}
	
	public ResponseEntity<ResponseStructure<List<Admin>>> getall(){
		ResponseStructure<List<Admin>> responseStructure = new ResponseStructure<List<Admin>>();
		responseStructure.setMessage("all admins has been found");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(adminDao.getall());
	    return new  ResponseEntity<ResponseStructure<List<Admin>>>(responseStructure,HttpStatus.OK);}
    public String getRole(int id) {
	    Optional<Admin> optional=adminDao.getby(id);
	    if(optional.isEmpty()) {
		   throw new IdNotFound();
	    }
	    else {
		   return optional.get().getRole();
	    }}


    public Admin findbyEmailnPassword(Admin admin) throws Exception {
    	return adminDao.findbyEmailnPassword(admin);}}


