package com.example.cartproduct.service.impl;

import com.example.cartproduct.model.Product;
import com.example.cartproduct.repository.IRepositoryProduct;
import com.example.cartproduct.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ServiceProduct implements IServiceProduct {
    @Autowired
    IRepositoryProduct repositoryProduct;

    @Override
    public List<Product> getAll() {
        return repositoryProduct.findAll();
    }

    @Override
    public Product getById(int id) {
        return repositoryProduct.findById(id).get();
    }

    @Override
    public List<Product> geProductstById(Set<Integer> productsIds) {
        return repositoryProduct.findAllById(productsIds);
    }
}
