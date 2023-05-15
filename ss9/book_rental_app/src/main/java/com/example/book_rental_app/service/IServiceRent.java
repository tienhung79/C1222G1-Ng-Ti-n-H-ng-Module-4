package com.example.book_rental_app.service;

import com.example.book_rental_app.model.Rent;

import java.util.List;

public interface IServiceRent {

    void creatNewRent(Rent rent);

    List<Rent> getAll();

    int checkCodeToRent();

    void delelteRent(Rent rent);
}
