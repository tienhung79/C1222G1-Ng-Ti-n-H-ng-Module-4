package com.example.book_rental_app.repository;

import com.example.book_rental_app.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryRent extends JpaRepository<Rent,Integer> {
//    @Query("select code from rent where code = ?")
//    int findByCode(int code);
}
