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

import com.cl.foodapp.entity.FoodOrder;
import com.cl.foodapp.service.FoodOrderService;
import com.cl.foodapp.responseStructure.ResponseStructure;

@RestController
public class FoodOrderController {

	@Autowired
	FoodOrderService ordersService;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveorders")
	public ResponseEntity<ResponseStructure<FoodOrder>> saveManager(@RequestBody FoodOrder orders){
		return ordersService.saveorders(orders);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> getby(@PathVariable int id){
		return ordersService.getby(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> delete(@PathVariable int id){
		return ordersService.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateorders/{id}")
	public ResponseEntity<ResponseStructure<FoodOrder>> update(@RequestBody FoodOrder orders,@PathVariable int id){
		return ordersService.update(orders,id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/orders")
	public ResponseEntity<ResponseStructure<List<FoodOrder>>> getall(){
		return ordersService.getall();
	}
}
