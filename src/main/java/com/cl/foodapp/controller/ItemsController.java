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

import com.cl.foodapp.entity.Item;
import com.cl.foodapp.service.ItemsService;
import com.cl.foodapp.responseStructure.ResponseStructure;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveitems")
	public ResponseEntity<ResponseStructure<Item>> saveManager(@RequestBody Item items){
		return itemsService.saveitems(items);
	}
	
	@GetMapping("/getitems/{id}")
	public ResponseEntity<ResponseStructure<Item>> getby(@PathVariable int id){
		return itemsService.getby(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteitems/{id}")
	public ResponseEntity<ResponseStructure<Item>> delete(@PathVariable int id){
		return itemsService.delete(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateitems/{id}")
	public ResponseEntity<ResponseStructure<Item>> update(@RequestBody Item items,@PathVariable int id){
		return itemsService.update(items,id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getitems")
	public ResponseEntity<ResponseStructure<List<Item>>> getall(){
		return itemsService.getall();
	}

}
