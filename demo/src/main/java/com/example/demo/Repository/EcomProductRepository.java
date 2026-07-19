package com.example.demo.Repository;

import com.example.demo.DTO.EcomProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcomProductRepository extends JpaRepository<EcomProducts,Integer> {
}
