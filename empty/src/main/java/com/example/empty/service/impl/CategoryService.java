package com.example.empty.service.impl;

import com.example.empty.model.Category;
import com.example.empty.repository.ICategoryRepostory;
import com.example.empty.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepostory categoryRepostory;

    @Override
    public List<Category> getAllCategory() {
        return categoryRepostory.findAll();
    }
}
