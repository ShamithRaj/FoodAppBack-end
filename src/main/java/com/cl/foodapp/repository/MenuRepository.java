package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
