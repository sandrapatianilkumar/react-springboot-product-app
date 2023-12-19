package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/create")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        Product saveProduct = new Product();
        saveProduct = service.save(product);
        return ResponseEntity.status(200).body(saveProduct);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = product;
        updatedProduct = service.updateById(id, product);
        return ResponseEntity.status(200).body(updatedProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = new ArrayList<Product>();
        allProducts = service.findAll();
        return ResponseEntity.status(200).body(allProducts);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product searchProduct =  service.findById(id);
        return ResponseEntity.status(200).body(searchProduct);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.status(200).body("Product Deleted Successfully");
    }
}