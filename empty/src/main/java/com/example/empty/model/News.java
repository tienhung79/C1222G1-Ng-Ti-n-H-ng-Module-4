package com.example.empty.model;

import javax.persistence.*;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titleNews;
    private String contentNews;
    @Column(columnDefinition = "date")
    private String dateUpNews;
    private String namePeople;
    @ManyToOne
    @JoinColumn(columnDefinition = "category_id", referencedColumnName = "id")
    Category category;

    public News() {
    }

    public News(int id, String titleNews, String contentNews, String dateUpNews, String namePeople, Category category) {
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
