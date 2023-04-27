package com.example.frontController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class frontController {
    @GetMapping("/result")
    public String disPlay(@RequestParam(defaultValue = "0",name = "englishCheck")String englishCheck, Model model){
        String[] vietnamese = {"xe hơi","xe máy","xe ô tô","máy bay"};
        String[] english = {"car","motobike","audi","plane"};
        String message = "Không tìm thấy";
        for (int i = 0; i < vietnamese.length; i++) {
            if (english[i].equals(englishCheck)){
                model.addAttribute("result",vietnamese[i]);
                break;
            } else {
                model.addAttribute("result", message);
            }
        }
        return "/view";
    }
}
