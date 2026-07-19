package com.example.demo.Controller;


import com.example.demo.DTO.Products;
import com.example.demo.ServiceImpl.ServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    ServiceImpl serviceImpl;

    //default session timeout is30min ,or else get logged out if you change the browser or restart the application




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

    //security

    @GetMapping("/")
    public String  greet(HttpServletRequest request)
    {
        return request.getSession().getId();
    }

    @GetMapping("/getCSRFToken")
    public CsrfToken getCSRFToken(HttpServletRequest request)
    {
        return (CsrfToken) request.getAttribute("_csrf");
    }




}
