package com.wsu.workorderproservice.repository;

import com.wsu.workorderproservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByActive(boolean active);
    
}
