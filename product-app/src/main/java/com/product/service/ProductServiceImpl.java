package com.product.service;

import com.product.model.Product;
import com.product.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product updateById(Long id, Product
            product) {
        Optional<Product> newProduct = repository.findById(id);
        if (newProduct.isPresent()) {
            newProduct.get().setId(product.getId());
            newProduct.get().setQuantity(product.getQuantity());
            newProduct.get().setPrice(product.getPrice());
            newProduct.get().setTitle(product.getTitle());
        } else {
            newProduct.orElseThrow(()-> new EntityNotFoundException("Product not found to update"));
        }
        return repository.save(newProduct.get());
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> newProduct = repository.findById(id);
        return newProduct.get();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}