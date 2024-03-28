package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
}
