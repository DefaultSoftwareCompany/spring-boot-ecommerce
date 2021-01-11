package com.dsc.service;

import com.dsc.model.Category;
import com.dsc.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }


    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category getOne(Short categoryId) throws Exception {
        Optional<Category> category = repository.findById(categoryId);
        if (category.isPresent()) return category.get();
        else throw new Exception("There is no category with the id");
    }

}
