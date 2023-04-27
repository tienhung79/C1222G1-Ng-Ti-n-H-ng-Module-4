package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {
    @GetMapping("/result")
    public String controller(Model model, @RequestParam(defaultValue = "0",name = "number") String usd){
        float number = Float.parseFloat(usd);
        float result = number * 23000;
        model.addAttribute("result",result);
        return "/view";
    }

}
