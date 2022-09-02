package com.cl.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.foodapp.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
