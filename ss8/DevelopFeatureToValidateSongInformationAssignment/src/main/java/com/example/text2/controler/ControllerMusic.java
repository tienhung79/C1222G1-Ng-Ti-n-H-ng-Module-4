package com.example.text2.controler;

import com.example.text2.model.Music;
import com.example.text2.modelDTO.MusicDTO;
import com.example.text2.service.IServiceMusic;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/music")
public class ControllerMusic {
    @Autowired
    IServiceMusic serviceMusic;

    @GetMapping("/music")
    public String disPlayMusic(Model model){
        List<Music> musicList = serviceMusic.getAll();
        model.addAttribute("musicList",musicList);
        return "/musicHome";
    }
    @GetMapping("/creatMusic")
    public String creatMusic(Model model){
        MusicDTO musicDTO = new MusicDTO();
        model.addAttribute("musicDTO",musicDTO);

        return "creatNewMusic";
    }
    @PostMapping("/creat")
    public String creat( @Validated @ModelAttribute("musicDTO") MusicDTO musicDTO,BindingResult bindingResult ,Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicDTO", musicDTO);
            return "creatNewMusic";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        serviceMusic.saveMusic(music);
        return "redirect:/music/music";
    }
}
