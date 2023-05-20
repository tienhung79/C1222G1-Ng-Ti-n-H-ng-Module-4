package com.example.formlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class ControllerLogin {
    @GetMapping("")
    public String displayHome(){
        return "/home";
    }
    @GetMapping("/login")
    public String login(){
        return "/loginPage";
    }
    @GetMapping("/admin")
    public String adminLogin
}
