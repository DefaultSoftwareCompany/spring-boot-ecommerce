package com.dsc.controller;

import com.dsc.model.Product;
import com.dsc.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;


    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/api/products/all")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/api/products/get/firm/{firmId}")
    public ResponseEntity<List<Product>> getAllByFirm(@PathVariable Long firmId) {
        return ResponseEntity.ok(service.getAllByFirm(firmId));
    }

    @GetMapping("/api/products/get/category/{categoryId}")
    public ResponseEntity<List<Product>> getAllByCategory(@PathVariable Short categoryId) {
        return ResponseEntity.ok(service.getAllByCategory(categoryId));
    }

}
