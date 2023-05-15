package com.example.moviereferencemanagement.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ShowtimeDTO implements Validator {
    private int id;
    private String codeShowtime;
    private String dateShowtime;
    private int quantityOfTickets;

    public ShowtimeDTO() {
    }

    public ShowtimeDTO(int id, String codeShowtime, String dateShowtime, int quantityOfTickets) {
        this.id = id;
        this.codeShowtime = codeShowtime;
        this.dateShowtime = dateShowtime;
        this.quantityOfTickets = quantityOfTickets;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
