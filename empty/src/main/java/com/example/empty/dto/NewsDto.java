package com.example.empty.dto;

import com.example.empty.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;


public class NewsDto {
    private int id;
    @NotBlank(message = "Không được để trống tiêu đề")
    private String titleNews;
    @NotBlank(message = "Không được để trống nội dung")

    private String contentNews;
    @NotBlank(message = "Không được để trống ngày đăng")
    private String dateUpNews;
    @NotBlank(message = "Không được để trống tên phóng viên")

    private String namePeople;
    Category category;

    public NewsDto() {
    }

    public NewsDto(int id, String titleNews, String contentNews, String dateUpNews, String namePeople, Category category) {
        this.id = id;
        this.titleNews = titleNews;
        this.contentNews = contentNews;
        this.dateUpNews = dateUpNews;
        this.namePeople = namePeople;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleNews() {
        return titleNews;
    }

    public void setTitleNews(String titleNews) {
        this.titleNews = titleNews;
    }

    public String getContentNews() {
        return contentNews;
    }

    public void setContentNews(String contentNews) {
        this.contentNews = contentNews;
    }

    public String getDateUpNews() {
        return dateUpNews;
    }

    public void setDateUpNews(String dateUpNews) {
        this.dateUpNews = dateUpNews;
    }

    public String getNamePeople() {
        return namePeople;
    }

    public void setNamePeople(String namePeople) {
        this.namePeople = namePeople;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
