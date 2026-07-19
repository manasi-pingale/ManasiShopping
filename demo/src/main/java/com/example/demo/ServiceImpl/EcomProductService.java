package com.example.demo.ServiceImpl;

import com.example.demo.DTO.EcomProducts;
import com.example.demo.Repository.EcomProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcomProductService {

    @Autowired
    private EcomProductRepository ecomProductRepository;

    public ResponseEntity<List<EcomProducts>> getAllProducts() {

        List<EcomProducts> li = ecomProductRepository.findAll();

        return ResponseEntity.ok(li);
    }
}
