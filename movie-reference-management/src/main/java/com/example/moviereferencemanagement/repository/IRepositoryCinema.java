package com.example.moviereferencemanagement.repository;

import com.example.moviereferencemanagement.model.Cinema;
import com.example.moviereferencemanagement.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryCinema extends JpaRepository<Cinema,Integer> {
}
