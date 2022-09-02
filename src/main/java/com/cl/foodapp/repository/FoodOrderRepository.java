package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}

