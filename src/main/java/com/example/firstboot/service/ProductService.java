package com.example.firstboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.firstboot.model.Product;
import com.example.firstboot.repository.ProductRepository;

@Service
//@Component
public class ProductService {

    ProductRepository productRepository;

    // @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
