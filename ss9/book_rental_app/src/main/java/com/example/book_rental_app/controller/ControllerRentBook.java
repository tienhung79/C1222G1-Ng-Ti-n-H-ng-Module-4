package com.example.book_rental_app.controller;

import com.example.book_rental_app.aspect.Logger;
import com.example.book_rental_app.exception_rent_or_give_back.ExceptionWhenToGiveBack;
import com.example.book_rental_app.exception_rent_or_give_back.ExceptionWhenToRent;
import com.example.book_rental_app.model.Book;
import com.example.book_rental_app.model.Rent;
import com.example.book_rental_app.service.IServiceBook;
import com.example.book_rental_app.service.IServiceRent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ControllerRentBook {
    @Autowired
    private IServiceBook serviceBook;
    @Autowired
    private IServiceRent serviceRent;

    @GetMapping("")
    public String disPlay(Model model) {
        List<Book> bookList = serviceBook.getAll();
        model.addAttribute("bookList", bookList);
        return "book_home";
    }

    @GetMapping("/rent/{idBook}")
    public String rentBook(@PathVariable(value = "idBook") int idBook, Model model) throws ExceptionWhenToRent {
        Book book = serviceBook.getById(idBook);
        if (book.getCountOfBook() == 0) {
            throw new ExceptionWhenToRent();
        }
        Rent rent = new Rent();
        int code = serviceRent.checkCodeToRent();

        rent.setCode(code);

        long time = System.currentTimeMillis();
        rent.setDate(new java.sql.Date(time));

        serviceRent.creatNewRent(rent);

        Rent rent1 = serviceRent.findRentById(rent.getId());
        model.addAttribute("codeOfRent", rent1);

        book.setCountOfBook(book.getCountOfBook() - 1);

        List<Rent> rentList = book.getList();
        rentList.add(rent);
        book.setList(rentList);

        serviceBook.creatNewBook(book);
        return "redirect:/home";
    }

    @ExceptionHandler(ExceptionWhenToRent.class)
    public String catchException() {
        return ("/dis_play_exception_when_to_rent");
    }

    @GetMapping("/giveBackBook/{id}")
    public String giveBack(@PathVariable int id, Model model) {
        Book book = serviceBook.getById(id);
        model.addAttribute("book", book);
        return "/fill_code_book";
    }

    @GetMapping("/giveBook")
    public String giveBook(@RequestParam(value = "code") int code, @RequestParam(value = "id") int id) throws ExceptionWhenToGiveBack {
        Book book = serviceBook.getById(id);
        List<Rent> rentList = serviceRent.getAll();
        int codeCheck = serviceRent.getByCode(code);
        for (int i = 0; i < rentList.size(); i++) {
            if (rentList.get(i).getCode() == code) {
                book.setCountOfBook(book.getCountOfBook() + 1);
                serviceBook.payBook(book);
                return "redirect:/home";
            }
        }
        throw new ExceptionWhenToGiveBack();
    }

    @ExceptionHandler(ExceptionWhenToGiveBack.class)
    public String catchExceptionWhenToGiveBack() {
        return ("/display_exception_when_to_give_back");
    }

}
