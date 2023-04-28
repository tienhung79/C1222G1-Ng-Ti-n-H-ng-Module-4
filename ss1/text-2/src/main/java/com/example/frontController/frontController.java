package com.example.frontController;

import com.example.service.IService;
import com.example.service.iml.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class frontController {
    IService service = new Service();
    @GetMapping("/result")
    public String disPlay(@RequestParam(defaultValue = "0",name = "englishCheck")String englishCheck, Model model){
        String result = service.check(englishCheck);
        model.addAttribute("result",result);
        return "/view";
    }
}
