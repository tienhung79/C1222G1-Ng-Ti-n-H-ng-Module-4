package com.example.springsecurity.repository;

import com.example.springsecurity.model.AppUser;
import com.example.springsecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepositoryUserRole extends JpaRepository<UserRole,Long> {
    List<UserRole> findByAppUser (AppUser appUser);
}
