package com.example.springsecurity.repository;

import com.example.springsecurity.model.Role;
import com.example.springsecurity.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryRole extends JpaRepository<UserRole,Long> {


}
