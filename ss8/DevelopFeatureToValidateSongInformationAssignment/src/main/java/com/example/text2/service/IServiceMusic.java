package com.example.text2.service;

import com.example.text2.model.Music;

import java.util.List;

public interface IServiceMusic {
    List<Music> getAll();

    void saveMusic(Music music);
}
