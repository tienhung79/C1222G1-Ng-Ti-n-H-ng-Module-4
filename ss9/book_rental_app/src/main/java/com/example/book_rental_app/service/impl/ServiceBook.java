package com.example.book_rental_app.service.impl;

import com.example.book_rental_app.model.Book;
import com.example.book_rental_app.repository.IRepositoryBook;
import com.example.book_rental_app.service.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBook implements IServiceBook {
    @Autowired
    IRepositoryBook repositoryBook;
    @Override
    public List<Book> getAll() {
        return repositoryBook.findAll();
    }
}
