package com.example.firstboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstboot.model.Product;
import com.example.firstboot.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }


    /*
     * Create
     * Get product by Id
     * get all products
     * update product
     * delete
     *      */
}
