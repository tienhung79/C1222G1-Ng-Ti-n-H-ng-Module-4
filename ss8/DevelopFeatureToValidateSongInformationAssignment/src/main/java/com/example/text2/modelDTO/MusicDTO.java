package com.example.text2.modelDTO;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDTO implements Validator {
    private int id;

    @NotNull
    @Size(max =800)
    @Pattern(regexp = "^[a-z A-Z]+$")
    private String name;

    @NotNull
    @Size(max =300)
    @Pattern(regexp = "^[a-z A-Z]+$")
    private String singer;

    @NotNull
    @Size(max = 1000)
    @Pattern(regexp = "[^,]*")
    private String category;

    public MusicDTO() {
    }

    public MusicDTO(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
