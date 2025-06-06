package com.example.produtosapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.produtosapp.model.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, String> {
    
    List<Product> findByName(String name);

}
