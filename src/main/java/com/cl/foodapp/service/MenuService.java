package com.cl.foodapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.foodapp.dao.MenuDao;
import com.cl.foodapp.entity.Menu;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class MenuService {
	
	@Autowired
	private MenuDao menuDao;
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(Menu menu){
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Saved");
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setT(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.CREATED);}
	
	public ResponseEntity<ResponseStructure<Menu>> getby(int id){
		Optional<Menu> menu=menuDao.getby(id);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if(menu.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("found");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(menu.get());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);}}
	
	public ResponseEntity<ResponseStructure<Menu>> delete(int id){
		Optional<Menu> menu=menuDao.getby(id);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if(menu.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("Deleted");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(menuDao.delete(id));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<Menu>> update(Menu menu,int id){
		Optional<Menu> menu2=menuDao.getby(id);
		ResponseStructure<Menu> responseStructure=new ResponseStructure<>();
		if(menu2.isEmpty()) {
			responseStructure.setMessage("Id not found");
			responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.NOT_FOUND);}
		else {
			responseStructure.setMessage("Updated");
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setT(menuDao.update(menu, id));
			return new ResponseEntity<ResponseStructure<Menu>>(responseStructure, HttpStatus.OK);}}
	public ResponseEntity<ResponseStructure<List<Menu>>> getall(){
		ResponseStructure<List<Menu>> responseStructure=new ResponseStructure<List<Menu>>();
		responseStructure.setMessage("Found");
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setT(menuDao.getall());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(responseStructure, HttpStatus.OK);}}
