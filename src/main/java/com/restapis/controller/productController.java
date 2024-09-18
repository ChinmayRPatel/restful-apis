package com.restapis.controller;

import com.restapis.entity.ProductEntity;
import com.restapis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class productController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/products")
    public ProductEntity createProduct(@RequestBody  ProductEntity product){
        System.out.println(product);
        productRepository.save(product);
        return product;
    }

    @GetMapping("/products")
    public List<ProductEntity> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{productId}")
    public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
        Optional<ProductEntity> op = productRepository.findById(productId);
        if (op.isEmpty()) {
            return null;
        } else {
            ProductEntity productEntity = op.get();
            return productEntity;
        }
    }

    @GetMapping("/productsbyid")
    public ProductEntity getProductById2(@RequestParam("productId") Integer productId) {
        Optional<ProductEntity> op = productRepository.findById(productId);
        if (op.isEmpty()) {
            return null;
        } else {
            ProductEntity productEntity = op.get();
            return productEntity;
        }
    }

}
