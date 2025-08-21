package com.example.firstboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstboot.model.Product;
import com.example.firstboot.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductsById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/testerror/{id}")
    public Product getProductsById2(@PathVariable int id) {
        return productService.getproductById2(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }

    @GetMapping("/name/{name}")
    public List<Product> getByName(@PathVariable String name) {
        return productService.findByName(name);
    }

    @GetMapping("/price/{price}")
    public List<Product> getByPrice(@PathVariable double price) {
        return productService.findByPrice(price);
    }

    @GetMapping("/expensive/{price}")
    public List<Product> findByPriceGreaterThan(@PathVariable double price) {
        return productService.findByPriceGreaterThan(price);
    }

    @GetMapping("/searchByName")
    public List<Product> searchByName(@RequestParam String name) {
        return productService.searchByName(name);
    }

    @GetMapping("/lower/{price}")
    public List<Product> findByPricelessthan(@PathVariable double price) {
        return productService.findByPricelessthan(price);
    }

    @GetMapping("/findBycategoryName")
    public List<Product> findBycategoryName(@RequestParam String name) {
        return productService.findBycategoryName(name);
    }

    /*
     * Controller->Service->Repository
     *      */
}
