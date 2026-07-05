package com.example.demo.Service;

import com.example.demo.DTO.Products;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceImpl {

    List<Products> productList = new ArrayList<>(List.of(
            new Products(1, "Laptop", 65000),
            new Products(2, "Mobile", 25000),
            new Products(3, "Headphones", 3000),
            new Products(4, "Keyboard", 1500)
    ));


    public List<Products> getProducts() {
        return productList;
    }

    // Get product by ID
    public Products getProductById(int id) {
        for (Products product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    // Add product
    public String addProduct(Products product) {
        productList.add(product);
        return "Product added successfully";
    }


}
