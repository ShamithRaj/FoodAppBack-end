package com.cl.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cl.foodapp.entity.FoodOrder;
import com.cl.foodapp.repository.FoodOrderRepository;

@Service
public class FoodOrderDao {
	
	@Autowired
	private FoodOrderRepository foodOrderRepository;
		public FoodOrder saveorders(FoodOrder orders) {
			return foodOrderRepository.save(orders);
		}
		public Optional<FoodOrder> getby(int id) {
			return foodOrderRepository.findById(id);
		}
		public FoodOrder delete(int id) {
			FoodOrder orders=getby(id).get();
			foodOrderRepository.delete(orders);
			return orders;
		}
		public FoodOrder update(FoodOrder orders, int id) {
			orders.setId(id);
			return foodOrderRepository.save(orders);
		}
		public List<FoodOrder> getall(){
			return foodOrderRepository.findAll();
		}

}
