package com.example.book_rental_app.service;

import com.example.book_rental_app.model.Book;

import java.util.List;

public interface IServiceBook {
    List<Book> getAll();

    Book getById(int idBook);

    void creatNewBook(Book book);

    void payBook(Book book);
}
