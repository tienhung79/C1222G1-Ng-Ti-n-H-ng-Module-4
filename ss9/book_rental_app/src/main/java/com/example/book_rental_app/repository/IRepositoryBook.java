package com.example.book_rental_app.repository;

import com.example.book_rental_app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryBook extends JpaRepository<Book,Integer> {
}
