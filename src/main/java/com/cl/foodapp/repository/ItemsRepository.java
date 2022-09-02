package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.Item;

public interface ItemsRepository extends JpaRepository<Item, Integer> {

}
