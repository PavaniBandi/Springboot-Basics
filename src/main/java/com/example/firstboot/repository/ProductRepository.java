package com.example.firstboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.firstboot.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByPrice(double price);

    List<Product> findByPriceGreaterThan(double price);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> searchByName(@Param("name") String name);

    @Query(value = "SELECT * FROM Product  WHERE price< :price", nativeQuery = true)
    List<Product> findByPricelessthan(@Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.category.name = :name")
    List<Product> findBycategoryName(@Param("name") String name);

}
