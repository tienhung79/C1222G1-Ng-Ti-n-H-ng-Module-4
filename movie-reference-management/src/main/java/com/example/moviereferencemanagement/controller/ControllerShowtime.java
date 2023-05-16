package com.example.moviereferencemanagement.controller;

import com.example.moviereferencemanagement.model.Cinema;
import com.example.moviereferencemanagement.model.Showtime;
import com.example.moviereferencemanagement.service.IServiceCinema;
import com.example.moviereferencemanagement.service.IServiceShowtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/home")
public class ControllerShowtime {
    @Autowired
    private IServiceShowtime serviceShowtime;

    @Autowired
    private IServiceCinema serviceCinema;
    @GetMapping("")
    public String disPlayShowtime(Model model) {
        List<Showtime> showtimeList = serviceShowtime.getAll();
        model.addAttribute("showtimeList", showtimeList);
        return "/home";
    }

    @GetMapping("/createNew")
    public String creatNewSHowtime(Model model) {
    List<Cinema> cinemaList = serviceCinema.getAll();
    Showtime showtime = new Showtime();
    model.addAttribute("cinemaList", cinemaList);
    model.addAttribute("showTime",showtime);
        return "/creat";
    }
    @PostMapping("/creat")
    public String creat(@ModelAttribute Showtime showtime){
        serviceShowtime.creatShowtime(showtime);
        return "redirect:/home";
    }
    @GetMapping("/delete")
    public String deleteById(@RequestParam(value = "idDelete") int id ) {
            serviceShowtime.deleteById(id);
        return "redirect:/home";
    }
}
