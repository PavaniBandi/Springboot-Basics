package com.example.firstboot.service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product getproductById2(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found" + id));
    }

    public void deleteProductById(int id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("product not found");
        }

        productRepository.deleteById(id);
    }

    public Product update(int id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product existing = productOptional.get();
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            return productRepository.save(existing);
        }
        return null;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    public List<Product> findByPriceGreaterThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    public List<Product> searchByName(String name) {
        return productRepository.searchByName(name);
    }

    public List<Product> findByPricelessthan(double price) {
        return productRepository.findByPricelessthan(price);
    }

    public List<Product> findBycategoryName(String name) {
        return productRepository.findBycategoryName(name);
    }
}
