package com.product;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {
    @Autowired
    ProductService productService;
    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();
        product.setTitle("iPhone");
        product.setPrice(1200D);
        product.setQuantity(99);
        productService.save(product);

        Product product2 = new Product();
        product2.setTitle("Blackberry");
        product2.setPrice(1100D);
        product2.setQuantity(55);
        productService.save(product2);

        Product product3 = new Product();
        product3.setTitle("Samsung");
        product3.setPrice(800D);
        product3.setQuantity(45);
        productService.updateById(2L, product3);


    }
}
