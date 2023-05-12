package mail.controller;

import mail.model.Mail;
import mail.service.IServiceMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mail")
public class ControllerMail {
    @Autowired
    private IServiceMail serviceMail;
    @GetMapping("")
    public String disPlayMail(Model model){
        Mail mail = serviceMail.getAll();
        model.addAttribute("mail",mail);
        return "/view";
    }
    @GetMapping("/updateMail")
    public String updateMail(Model model){
        Mail mail = serviceMail.getAll();
        model.addAttribute("mail",mail);
        List<String> languageList = serviceMail.getLanguagList();
        model.addAttribute("languageList",languageList);
        List<Integer> pageSizeList = serviceMail.getPagaSizeList();
        model.addAttribute("pageSizeList",pageSizeList);
        return "/update";
    }
    @PostMapping("/update")
    public String updateMail(@ModelAttribute Mail mail){
        this.serviceMail.update(mail);
        return "redirect:/mail";
    }
}
