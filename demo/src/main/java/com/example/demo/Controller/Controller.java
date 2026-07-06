package com.example.demo.Controller;


import com.example.demo.DTO.Products;
import com.example.demo.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    ServiceImpl serviceImpl;

    @GetMapping("/getProducts")
    public List<Products> getProducts() {
        return serviceImpl.getProducts();
    }

    // Get product by ID
    @GetMapping("/getProductsById/{id}")
    public Products getProductById(@PathVariable int id) {
        return serviceImpl.getProductById(id);
    }

    // Add a new product
    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Products product) {
        return serviceImpl.addProduct(product);
    }

    @PutMapping("/updateProduct")
    public String updateProducts(@RequestBody Products products)
    {
        return serviceImpl.updateProduct(products);
    }

    @PutMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        return serviceImpl.deleteProduct(id);
    }





}
