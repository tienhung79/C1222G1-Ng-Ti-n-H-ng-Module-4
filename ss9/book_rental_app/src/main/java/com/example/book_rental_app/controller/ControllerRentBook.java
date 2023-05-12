package com.example.book_rental_app.controller;

import com.example.book_rental_app.model.Book;
import com.example.book_rental_app.model.Rent;
import com.example.book_rental_app.service.IServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ControllerRentBook {
    @Autowired
    IServiceBook serviceBook;
    @GetMapping("")
    public String disPlay(Model model){
        List<Book> bookList = serviceBook.getAll();
        model.addAttribute("bookList",bookList);
        return "/bookHome";
    }
    @GetMapping("/rent/{idBook}")
    public String rentBook(@PathVariable(value = "idBook")int idBook){
        Rent rent = new Rent();
        int code = (int) Math.random()*(9999-1000);
        rent.setCode(code);

        long time= System.currentTimeMillis();
        rent.setDate(new java );
        return
    }
}
