package com.dsc.repository;

import com.dsc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> getAllByCategory_CategoryId(Short categoryId);

    List<Product> getAllByFirm_FirmId(Long firmId);
}
