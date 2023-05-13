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


        book.setCountOfBook(book.getCountOfBook() - 1);

        List<Rent> rentList = book.getList();
        rentList.add(rent);
        book.setList(rentList);

        serviceBook.creatNewBook(book);
        Logger logger = new Logger();
       model.addAttribute("cusomerList",logger.checkRent())
        return "redirect:/home";
    }

    @GetMapping("/giveBackBook")
    public String giveBack() {

        return "/fill_code_book";
    }

    @ExceptionHandler(ExceptionWhenToRent.class)
    public String catchException() {
        return ("/dis_play_exception_when_to_rent");
    }

    @GetMapping("/giveBook")
    public String giveBook(@RequestParam(value = "code") int code) throws ExceptionWhenToGiveBack {
//        List<Rent> rentList = book.getList();
        List<Book> bookList = serviceBook.getAll();
        List<Rent> rentList = serviceRent.getAll();
        for (int i = 0; i < rentList.size(); i++) {
            if (rentList.get(i).getCode() == code) {
                rentList.get(i).getId();
                return "redirect:/home";

            }
        }
        throw new ExceptionWhenToGiveBack();
    }

    @ExceptionHandler(ExceptionWhenToGiveBack.class)
    public ModelAndView catchExceptionWhenToGiveBack() {
        return new ModelAndView("/display_exception_when_to_give_back");
    }

}
