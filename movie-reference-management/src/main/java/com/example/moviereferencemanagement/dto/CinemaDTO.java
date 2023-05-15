package com.example.moviereferencemanagement.dto;

public class CinemaDTO {
    private int id;
    private String nameCinema;

    public CinemaDTO() {
    }

    public CinemaDTO(int id, String nameCinema) {
        this.id = id;
        this.nameCinema = nameCinema;
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
}
