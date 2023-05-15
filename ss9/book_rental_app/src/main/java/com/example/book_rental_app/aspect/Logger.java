package com.example.book_rental_app.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
    @Pointcut("execution(* com.example.book_rental_app.controller.ControllerRentBook.rentBook(..))")
    public void writeLogOnGettingRentBook(){

    }
    @AfterThrowing("writeLogOnGettingRentBook()")
    public void checkException(){
        System.out.println("--------3-----");
        System.out.println("Not enough book for rent");
    }
    @After("writeLogOnGettingRentBook()")
    public void checkRent(){
        System.out.println("-------------");
        System.out.println("Done");
    }
}
