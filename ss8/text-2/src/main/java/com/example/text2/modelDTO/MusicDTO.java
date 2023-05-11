package com.example.text2.modelDTO;

import com.example.text2.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MusicDTO implements Validator {
    private int id;
    @NotNull
    @Max(800)
    @Pattern(regexp = "/^[a-z A-Z]+$/")
    private String name;
    @NotNull
    @Max(300)
    @Pattern(regexp = "/^[a-z A-Z]+$/")
    private String singer;
    private Category category;

    public MusicDTO() {
    }

    public MusicDTO(int id, String name, String singer, Category category) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
