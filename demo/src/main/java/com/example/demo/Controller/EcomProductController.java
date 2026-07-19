package com.example.demo.Controller;

import com.example.demo.DTO.EcomProducts;
import com.example.demo.ServiceImpl.EcomProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ecomapi")
public class EcomProductController {

    @Autowired
    EcomProductService service;

    @GetMapping("/getAllEcomProducts")
    public ResponseEntity<List<EcomProducts>> getAllProducts()
    {
        return service.getAllProducts();
    }
}
