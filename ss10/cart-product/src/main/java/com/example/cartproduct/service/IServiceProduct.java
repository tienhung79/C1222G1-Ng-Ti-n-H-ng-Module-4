package com.example.cartproduct.service;

import com.example.cartproduct.model.Product;

import java.util.List;
import java.util.Set;

public interface IServiceProduct {
    List<Product> getAll();

    Product getById(int id);

    List<Product> geProductstById(Set<Integer> productsIds);
}
