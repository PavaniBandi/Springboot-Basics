package com.example.firstboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.firstboot.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
