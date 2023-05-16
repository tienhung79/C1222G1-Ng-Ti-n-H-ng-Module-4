package com.example.moviereferencemanagement.service.impl;

import com.example.moviereferencemanagement.model.Showtime;
import com.example.moviereferencemanagement.repository.IRepositoryShowtime;
import com.example.moviereferencemanagement.service.IServiceShowtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceShowtime implements IServiceShowtime {
    @Autowired
    private IRepositoryShowtime repositoryShowtime;
    @Override
    public List<Showtime> getAll() {
        return repositoryShowtime.findAll();
    }

    @Override
    public void creatShowtime(Showtime showtime) {
        repositoryShowtime.save(showtime);
    }

    @Override
    public void deleteById(int id) {
        repositoryShowtime.deleteById(id);
    }
}
