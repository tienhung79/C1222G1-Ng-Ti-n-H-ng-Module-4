package com.example.empty.repository;

import com.example.empty.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepostory extends JpaRepository<Category,Integer> {
}
