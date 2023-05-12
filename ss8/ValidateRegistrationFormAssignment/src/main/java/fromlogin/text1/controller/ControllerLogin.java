package fromlogin.text1.controller;

import fromlogin.text1.dto.UserDTO;
import fromlogin.text1.model.User;
import fromlogin.text1.service.IServiceLogin;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class ControllerLogin {
    @Autowired
    IServiceLogin serviceLogin;

    @GetMapping("")
    public String disPlay(@PageableDefault(size = 1) Pageable pageable, Model model) {
        Page<User> loginPage = serviceLogin.getLoginPage(pageable);
        model.addAttribute("pageLogin", loginPage);
        return "/loginHome";
    }

    @GetMapping("/creatUser")
    public String creatUser(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user",userDTO);
       return "/creat";
    }
    @PostMapping("/saveUser")
    public String creat(@Validated @ModelAttribute("user") UserDTO userDTO,BindingResult bindingResult, Model model){
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDTO);
            return "/creat";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        serviceLogin.creatUser(user);
        return "redirect:/login";
    }

    @GetMapping("/updateById/{id}")
    public String updateById(@PathVariable(value = "id") int id, Model model) {
        User login = serviceLogin.getById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(login, userDTO);
        model.addAttribute("userDTO", userDTO);
//        return "redirect:/login";
        return "/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, Model model) {
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "/update";
        }
        User login = new User();
        BeanUtils.copyProperties(userDTO, login);
        serviceLogin.update(login);
        return "redirect:/login";
    }
}
