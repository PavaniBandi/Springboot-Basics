package com.example.firstboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstboot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
