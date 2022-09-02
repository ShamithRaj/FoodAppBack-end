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

import com.cl.foodapp.entity.Menu;
import com.cl.foodapp.service.MenuService;
import com.cl.foodapp.responseStructure.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/savemenu")
	public ResponseEntity<ResponseStructure<Menu>> saveManager(@RequestBody Menu menu){
		return menuService.saveMenu(menu);
	}
	
	@GetMapping("/getmenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> getby(@PathVariable int id){
		return menuService.getby(id);
	}
	
	@DeleteMapping("/deletemenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> delete(@PathVariable int id){
		return menuService.delete(id);
	}
	
	@PostMapping("/updatemenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> update(@RequestBody Menu menu,@PathVariable int id){
		return menuService.update(menu,id);
	}
	
	@GetMapping("/getallmenu")
	public ResponseEntity<ResponseStructure<List<Menu>>> getall(){
		return menuService.getall();
	}

}
