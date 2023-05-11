package com.example.text2.repository;

import com.example.text2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCategory extends JpaRepository<Category,Integer> {
}
