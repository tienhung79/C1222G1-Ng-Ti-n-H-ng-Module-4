package com.example.controller;

import com.example.service.IService;
import com.example.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FrontController {
    IService service = new Service();
    @GetMapping("/result")
    public String controller(Model model, @RequestParam(defaultValue = "0",name = "number") String usd){
        float number = Float.parseFloat(usd);
        float result = service.caculator(number);
        model.addAttribute("result",result);
        return "/view";
    }

}
