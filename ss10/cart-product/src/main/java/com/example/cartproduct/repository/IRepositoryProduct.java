package com.example.cartproduct.repository;

import com.example.cartproduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryProduct extends JpaRepository<Product,Integer> {
}
