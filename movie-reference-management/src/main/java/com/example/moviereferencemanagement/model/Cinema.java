package com.example.moviereferencemanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameCinema;

    @OneToMany(mappedBy = "cinema")
    private List<Showtime> showtimeList;

    public Cinema() {
    }

    public Cinema(int id, String nameCinema, List<Showtime> showtimeList) {
        this.id = id;
        this.nameCinema = nameCinema;
        this.showtimeList = showtimeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCinema() {
        return nameCinema;
    }

    public void setNameCinema(String nameCinema) {
        this.nameCinema = nameCinema;
    }

    public List<Showtime> getShowtimeList() {
        return showtimeList;
    }

    public void setShowtimeList(List<Showtime> showtimeList) {
        this.showtimeList = showtimeList;
    }
}
