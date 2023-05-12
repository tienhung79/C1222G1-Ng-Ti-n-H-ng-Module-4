package com.example.book_rental_app.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int countOfBook;

    @ManyToMany
    @JoinTable(name = "rent_book",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "rent_id")
    )
    List<Rent> list;
    public Book() {
    }

    public Book(int id, String name, int countOfBook) {
        this.id = id;
        this.name = name;
        this.countOfBook = countOfBook;
    }

    public Book(int id, String name, int countOfBook, List<Rent> list) {
        this.id = id;
        this.name = name;
        this.countOfBook = countOfBook;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfBook() {
        return countOfBook;
    }

    public List<Rent> getList() {
        return list;
    }

    public void setList(List<Rent> list) {
        this.list = list;
    }

    public void setCountOfBook(int countOfBook) {
        this.countOfBook = countOfBook;

    }
}
