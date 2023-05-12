package com.example.text2.service.impl;

import com.example.text2.model.Music;
import com.example.text2.repository.IRepositoryMusic;
import com.example.text2.service.IServiceMusic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMusic implements IServiceMusic {
    @Autowired
    IRepositoryMusic repositoryMusic;
    @Override
    public List<Music> getAll() {
        return repositoryMusic.findAll();
    }

    @Override
    public void saveMusic(Music music) {
        repositoryMusic.save(music);
    }
}
