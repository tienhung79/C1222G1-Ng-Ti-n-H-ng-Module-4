package buildBlog.controller;

import buildBlog.model.Blog;
import buildBlog.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cagetory")
public class ControllerCategoryBlog {
    @Autowired
    private IServiceCategory serviceCategory;
//    private Blog blog;



}
