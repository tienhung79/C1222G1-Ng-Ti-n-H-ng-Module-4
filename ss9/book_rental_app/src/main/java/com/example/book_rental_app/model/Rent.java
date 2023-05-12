package com.example.book_rental_app.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Set;

@Entity
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int code;
    private Date date;

    public Rent() {
    }

    public Rent(int id, int code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
