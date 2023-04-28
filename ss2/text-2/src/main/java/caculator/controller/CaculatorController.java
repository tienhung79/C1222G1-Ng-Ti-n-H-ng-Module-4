package caculator.controller;

import caculator.service.ICaculatorService;
import caculator.service.iml.CaculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/caculator")
public class CaculatorController {
    private ICaculatorService caculatorService = new CaculatorService();
    @GetMapping("")
    public String caculate(@RequestParam(value = "number1",required = false,defaultValue = "0") int number1, @RequestParam(value = ("number2"),required = false,defaultValue = "0") int
                           number2, @RequestParam(value = "caculate",required = false,defaultValue = "0")String caculate, Model model){
        model.addAttribute("result",caculatorService.caculate(number1,number2,caculate));
        return "/view";
    }

}
