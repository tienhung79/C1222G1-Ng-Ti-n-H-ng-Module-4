package com.example.springsecurity.repository;


import com.example.springsecurity.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryAppUser extends JpaRepository<AppUser,Long> {
    AppUser findByUserName(String userName);
}
