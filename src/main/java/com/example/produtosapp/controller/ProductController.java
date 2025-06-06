package com.example.produtosapp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtosapp.model.Product;
import com.example.produtosapp.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<Product> getByName(@RequestParam String name) {
        return repository.findByName(name);
    }

    @GetMapping("/{id}")
    public Product getBy(@PathVariable String id) {
        Optional<Product> product = repository.findById(id);
        return product.isPresent() ? product.get() : null;
    }

    @PostMapping
    public void post(@RequestBody Product product) {
        product.setId(UUID.randomUUID().toString());
        repository.save(product);
        System.out.println("Produto recebido: " + product.toString());
    }

    @PutMapping("{id}")
    public void put(@RequestBody Product product, @PathVariable String id) {
        product.setId(id);
        repository.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
