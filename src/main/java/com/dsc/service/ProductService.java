package com.dsc.service;

import com.dsc.model.Product;
import com.dsc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product getOne(Long productId) throws Exception {
        Optional<Product> product = repository.findById(productId);
        if (product.isPresent()) return product.get();
        else throw new Exception("There is no product with such an id");
    }

    public List<Product> getAllByCategory(Short categoryId) {
        return repository.getAllByCategory_CategoryId(categoryId);
    }

    public List<Product> getAllByFirm(Long firmId) {
        return repository.getAllByFirm_FirmId(firmId);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }
}
