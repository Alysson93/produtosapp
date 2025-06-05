package com.example.produtosapp.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtosapp.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @PostMapping
    public void post(@RequestBody Product product) {
        System.out.println("Produto recebido: " + product.toString());
    }

}
