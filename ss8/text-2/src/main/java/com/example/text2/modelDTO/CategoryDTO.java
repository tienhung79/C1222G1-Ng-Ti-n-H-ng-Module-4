package com.example.text2.modelDTO;

import com.example.text2.model.Music;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CategoryDTO implements Validator {
    private int id;
    @NotBlank
    @Max(1000)
    @Pattern(regexp = "^[^,]*$")
    private String nameCategory;
    private List<Music> musicList;

    public CategoryDTO() {
    }

    public CategoryDTO(int id, String nameCategory, List<Music> musicList) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
