package com.example.moviereferencemanagement.service;

import com.example.moviereferencemanagement.model.Showtime;

import java.util.List;

public interface IServiceShowtime {
    List<Showtime> getAll();

    void creatShowtime(Showtime showtime);

    void deleteById(int id);
}
