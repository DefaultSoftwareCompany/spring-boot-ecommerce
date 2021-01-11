package com.dsc.controller;

import com.dsc.model.Category;
import com.dsc.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/api/category/all")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/api/category/get/{categoryId}")
    public ResponseEntity<Category> getOne(@PathVariable Short categoryId) throws Exception {
        return ResponseEntity.ok(service.getOne(categoryId));
    }
}
