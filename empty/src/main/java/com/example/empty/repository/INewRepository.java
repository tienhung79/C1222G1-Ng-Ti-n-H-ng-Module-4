package com.example.empty.repository;

import com.example.empty.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INewRepository extends JpaRepository<News,Integer> {
}
