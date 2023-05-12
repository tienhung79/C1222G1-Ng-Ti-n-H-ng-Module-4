package com.example.text2.repository;

import com.example.text2.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositoryMusic extends JpaRepository<Music,Integer> {
}
