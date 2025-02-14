package com.example.ShoppingCart.repository;

import com.example.ShoppingCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteByName(String name);
}
