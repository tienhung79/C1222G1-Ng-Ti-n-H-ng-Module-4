package com.example.moviereferencemanagement.model;

import javax.persistence.*;


@Entity
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codeShowtime;
    private String dateShowtime;
    private int quantityOfTickets;

    @ManyToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private Cinema cinema;

    public Showtime() {
    }

    public Showtime(int id, String codeShowtime, String dateShowtime, int quantityOfTickets, Cinema cinema) {
        this.id = id;
        this.codeShowtime = codeShowtime;
        this.dateShowtime = dateShowtime;
        this.quantityOfTickets = quantityOfTickets;
        this.cinema = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeShowtime() {
        return codeShowtime;
    }

    public void setCodeShowtime(String codeShowtime) {
        this.codeShowtime = codeShowtime;
    }

    public String getDateShowtime() {
        return dateShowtime;
    }

    public void setDateShowtime(String dateShowtime) {
        this.dateShowtime = dateShowtime;
    }

    public int getQuantityOfTickets() {
        return quantityOfTickets;
    }

    public void setQuantityOfTickets(int quantityOfTickets) {
        this.quantityOfTickets = quantityOfTickets;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
