package com.cl.foodapp.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.foodapp.dao.ItemsDao;
import com.cl.foodapp.dao.StaffDao;
import com.cl.foodapp.entity.Item;
import com.cl.foodapp.responseStructure.ResponseStructure;

@Service
public class ItemsService {
	
	@Autowired
	ItemsDao itemsDao;
	
	@Autowired
	StaffDao staffDao;
			public ResponseEntity<ResponseStructure<Item>> saveitems(Item items){
				ResponseStructure<Item> responseStructure = new ResponseStructure<>();
				responseStructure.setMessage("Saved");
				responseStructure.setStatuscode(HttpStatus.CREATED.value());
				responseStructure.setT(itemsDao.saveItems(items));
				return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.CREATED);}
			
			public ResponseEntity<ResponseStructure<Item>> getby(int id){
				Optional<Item> items=itemsDao.getby(id);
				ResponseStructure<Item> responseStructure=new ResponseStructure<>();
				if(items.isEmpty()) {
					responseStructure.setMessage("Id not found");
					responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
					return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.NOT_FOUND);}
				else {
				responseStructure.setMessage("Saved");
				responseStructure.setStatuscode(HttpStatus.OK.value());
				responseStructure.setT(items.get());
				return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);}}
			public ResponseEntity<ResponseStructure<Item>> delete(int id){
				Optional<Item> items=itemsDao.getby(id);
				ResponseStructure<Item> responseStructure=new ResponseStructure<>();
				if(items.isEmpty()) {
					responseStructure.setMessage("Id not found");
					responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
					return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.NOT_FOUND);}
				else {
				responseStructure.setMessage("deleted");
				responseStructure.setStatuscode(HttpStatus.OK.value());
				responseStructure.setT(itemsDao.delete(id));
				return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);}}
			
			public ResponseEntity<ResponseStructure<Item>> update(Item items,int id){
				Optional<Item> items2=itemsDao.getby(id);
				ResponseStructure<Item> responseStructure=new ResponseStructure<>();
				if(items2.isEmpty()) {
					responseStructure.setMessage("Id not found");
					responseStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
					return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.NOT_FOUND);}
				else {
				responseStructure.setMessage("Updated");
				responseStructure.setStatuscode(HttpStatus.OK.value());
				responseStructure.setT(itemsDao.update(items, id));
				return new ResponseEntity<ResponseStructure<Item>>(responseStructure,HttpStatus.OK);}}
			public ResponseEntity<ResponseStructure<List<Item>>> getall(){
				ResponseStructure<List<Item>> responseStructure=new ResponseStructure<List<Item>>();
				responseStructure.setMessage("Found");
				responseStructure.setStatuscode(HttpStatus.OK.value());
				responseStructure.setT(itemsDao.getall());
				return new ResponseEntity<ResponseStructure<List<Item>>>(responseStructure, HttpStatus.OK);}
}
