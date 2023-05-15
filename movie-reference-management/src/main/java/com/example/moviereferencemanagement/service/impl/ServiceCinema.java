package com.example.moviereferencemanagement.service.impl;

import com.example.moviereferencemanagement.model.Cinema;
import com.example.moviereferencemanagement.repository.IRepositoryCinema;
import com.example.moviereferencemanagement.service.IServiceCinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCinema implements IServiceCinema {
    @Autowired
    IRepositoryCinema repositoryCinema;
    @Override
    public List<Cinema> getAll() {
        return repositoryCinema.findAll();
    }
}
