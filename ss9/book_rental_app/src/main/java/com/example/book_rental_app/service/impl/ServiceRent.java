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
   private IRepositoryRent repositoryRent;


    @Override
    public void creatNewRent(Rent rent) {
        repositoryRent.save(rent);
    }

    @Override
    public List<Rent> getAll() {
        return repositoryRent.findAll();
    }

    @Override
    public int checkCodeToRent() {
        List<Rent> rentList = getAll();
       int code = (int) (Math.random() * (99999 - 10000) + 10000);
        for (int i = 0; i < rentList.size(); i++) {
            if (code == rentList.get(i).getCode()) {
                code = (int) (Math.random() * (99999 - 10000) + 10000);
                i = 0;
            }
        }
        return code;
    }

    @Override
    public void delelteRent(Rent rent) {
        repositoryRent.delete(rent);
    }

    @Override
    public Rent findRentById(int id) {
        return repositoryRent.findById(id).get();
    }

    @Override
    public int getByCode(int code) {
        return repositoryRent.findByCode(code);
    }
}
