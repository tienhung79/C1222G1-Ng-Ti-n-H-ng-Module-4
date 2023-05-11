package com.example.text2.model;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameCategory;
    @OneToMany(mappedBy = "category")
    private List<Music> musicList;

    public Category() {
    }

    public Category(int id, String nameCategory, List<Music> musicList) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.musicList = musicList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
}
