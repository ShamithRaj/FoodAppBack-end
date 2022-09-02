package com.cl.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.foodapp.entity.Item;
import com.cl.foodapp.repository.ItemsRepository;

@Repository
public class ItemsDao {
	
	@Autowired
	ItemsRepository itemsRepository;
		public Item saveItems(Item items) {
			return itemsRepository.save(items);
		}
		public Optional<Item> getby(int id) {
			return itemsRepository.findById(id);
		}
		public Item delete(int id) {
			Item items=getby(id).get();
			itemsRepository.delete(items);
			return items;
		}
		public Item update(Item items, int id) {
			items.setId(id);
			return itemsRepository.save(items);
		}
		public List<Item> getall(){
			return itemsRepository.findAll();
		}

}
