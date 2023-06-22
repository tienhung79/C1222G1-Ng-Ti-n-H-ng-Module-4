package com.example.empty.controller;

import com.example.empty.dto.NewsDto;
import com.example.empty.model.Category;
import com.example.empty.model.News;
import com.example.empty.service.ICategoryService;
import com.example.empty.service.INewsService;
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

import java.util.List;

@Controller
@RequestMapping("")
public class NewsController {
    @Autowired
    private INewsService newsService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    String disPlayNews(@PageableDefault(size = 2) Pageable pageable, Model model) {
        Page<News> newsPage = newsService.getAllNews(pageable);
        model.addAttribute("newsPage", newsPage);
        return "/home";
    }

    @GetMapping("/creatNews")
    String creatNew(Model model) {
        NewsDto newsDto = new NewsDto();
        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("newsDto", newsDto);
        model.addAttribute("categoryList", categoryList);
        return "/creat";
    }

    @PostMapping("/creat")
    String creat(@Validated @ModelAttribute(value = "newsDto") NewsDto newsDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Category> categoryList = categoryService.getAllCategory();
            model.addAttribute("newsDto", newsDto);
            model.addAttribute("categoryList", categoryList);
            return "/creat";
        }
        News news = new News();
        BeanUtils.copyProperties(newsDto, news);
        newsService.creatNews(news);
        return "redirect:/";
    }

    @GetMapping("/deleteNew")
    String delete(@RequestParam(value = "idDelete") int id) {
        newsService.deleteNew(id);
        return "redirect:/";
    }
}
