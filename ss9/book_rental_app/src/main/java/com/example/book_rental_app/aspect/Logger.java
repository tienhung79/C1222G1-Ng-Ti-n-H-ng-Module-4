package com.example.book_rental_app.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class Logger {
    @Pointcut("execution(* com.example.book_rental_app.controller.ControllerRentBook.rentBook(..))")
    public void writeLogOnGettingRentBook(){

    }
    @AfterThrowing("writeLogOnGettingRentBook()")
    public void checkException(){
        System.out.println("--------------");
        System.out.println("Not enough book for rent");
    }
    @After("writeLogOnGettingRentBook()")
    public void checkRent(){
        System.out.println("-------------");
        System.out.println("Done");
    }
    @AfterReturning("writeLogOnGettingRentBook()")
    public void changeRentBook(JoinPoint joinPoint){
        System.out.println("Chang for Book");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(joinPoint.getArgs()[0]);
    }

}
