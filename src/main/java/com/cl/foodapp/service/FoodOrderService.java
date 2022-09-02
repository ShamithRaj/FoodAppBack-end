package com.cl.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.foodapp.dao.FoodOrderDao;
import com.cl.foodapp.dao.StaffDao;
import com.cl.foodapp.entity.FoodOrder;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class FoodOrderService {

	@Autowired
	private FoodOrderDao orderDao;

	@Autowired
	StaffDao staffDao;
	public ResponseEntity<ResponseStructure<FoodOrder>> saveorders(FoodOrder orders) {
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		responseStructure.setMessage("Saved successfully");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(orderDao.saveorders(orders));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.CREATED);}
	public ResponseEntity<ResponseStructure<FoodOrder>> getby(int id) {
		Optional<FoodOrder> orders = orderDao.getby(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (orders.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.NOT_FOUND);} 
		else {
			responseStructure.setMessage("All the staffs has been found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(orders.get());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);}}

	public ResponseEntity<ResponseStructure<FoodOrder>> delete(int id) {
		Optional<FoodOrder> orders = orderDao.getby(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (orders.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.NOT_FOUND);} 
		else {
			responseStructure.setMessage("Staff has been deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(orderDao.delete(id));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<FoodOrder>> update(FoodOrder orders, int id) {
		Optional<FoodOrder> orders2 = orderDao.getby(id);
		ResponseStructure<FoodOrder> responseStructure = new ResponseStructure<>();
		if (orders2.isEmpty()) {
			responseStructure.setMessage("ID not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.NOT_FOUND);} 
		else {
			responseStructure.setMessage("Staff has been Updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(orderDao.update(orders, id));
			return new ResponseEntity<ResponseStructure<FoodOrder>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> getall() {
		ResponseStructure<List<FoodOrder>> responseStructure = new ResponseStructure<List<FoodOrder>>();
		responseStructure.setMessage("Found all");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(orderDao.getall());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(responseStructure, HttpStatus.OK);}}