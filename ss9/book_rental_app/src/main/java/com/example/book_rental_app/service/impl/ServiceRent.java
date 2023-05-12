package com.example.book_rental_app.service.impl;

import com.example.book_rental_app.model.Rent;
import com.example.book_rental_app.repository.IRepositoryRent;
import com.example.book_rental_app.service.IServiceRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRent implements IServiceRent  {
    @Autowired
    IRepositoryRent repositoryRent;


    @Override
    public void creatNewRent(Rent rent) {
        repositoryRent.save(rent);
    }

    @Override
    public List<Rent> getAll() {
        return repositoryRent.findAll();
    }
}
