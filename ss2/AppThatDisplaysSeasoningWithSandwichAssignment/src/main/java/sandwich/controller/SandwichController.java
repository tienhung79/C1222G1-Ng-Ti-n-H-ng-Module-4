package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sandwich.service.ISanfwichService;
import sandwich.service.iml.SandwichService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sandwich")
public class SandwichController {
    private ISanfwichService sanfwichService = new SandwichService();

    @GetMapping()
    public String getView(Model model,@RequestParam(value = "spice", required = false) String[] spiceList) {
        List<String> spice = sanfwichService.getSpiceList();
        model.addAttribute("ListSpice", spice);
        model.addAttribute("spiceList", spiceList);
        return "/view";
    }
}
