package com.cl.foodapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.foodapp.dao.BranchManagerDao;
import com.cl.foodapp.entity.BranchManager;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class BranchManagerService {
	
	@Autowired
	private BranchManagerDao branchManagerDao;
	public ResponseEntity<ResponseStructure<BranchManager>> saveManager(BranchManager manager){
		ResponseStructure<BranchManager> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("BranchManager has been Saved");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(branchManagerDao.saveManager(manager));
		return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.CREATED);}
	public ResponseEntity<ResponseStructure<BranchManager>> getby(int id){
		Optional<BranchManager> manager = branchManagerDao.getby(id);
		ResponseStructure<BranchManager> responseStructure=new ResponseStructure<>();
		if(manager.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("BranchManager has been found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(manager.get());
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.OK);}}
	
	public ResponseEntity<ResponseStructure<BranchManager>> delete(int id){
		Optional<BranchManager> manager = branchManagerDao.getby(id);
		ResponseStructure<BranchManager> responseStructure=new ResponseStructure<>();
		if(manager.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("Branch Manager has been Deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(branchManagerDao.delete(id));
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.OK);}}
	
	public ResponseEntity<ResponseStructure<BranchManager>> update(BranchManager manager,int id){
		Optional<BranchManager> manager1 = branchManagerDao.getby(id);
		ResponseStructure<BranchManager> responseStructure=new ResponseStructure<>();
		if(manager1.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("BranchManager has been Updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(branchManagerDao.update(manager, id));
			return new ResponseEntity<ResponseStructure<BranchManager>>(responseStructure,HttpStatus.OK);}}
	
	public ResponseEntity<ResponseStructure<List<BranchManager>>> getall(){
		ResponseStructure<List<BranchManager>> responseStructure=new ResponseStructure<List<BranchManager>>();
		responseStructure.setMessage("All Branch Managers has been found");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(branchManagerDao.getall());
		return new ResponseEntity<ResponseStructure<List<BranchManager>>>(responseStructure,HttpStatus.OK);}
	
	public BranchManager findbyEmailnPassword(BranchManager manager) throws Exception {
		return branchManagerDao.findByEmailAndPassword(manager);
	}
}

