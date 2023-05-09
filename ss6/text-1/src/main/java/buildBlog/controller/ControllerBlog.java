package buildBlog.controller;

import buildBlog.model.Blog;
import buildBlog.service.IServiceBlog;
import buildBlog.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class ControllerBlog {
    @Autowired
   private IServiceBlog serviceBlog;
    private IServiceCategory serviceCategory;
    @GetMapping("/blogHome")
    public String disPlayBlog(Model model){
        List<Blog> blogList = serviceBlog.getAllBlog();
        model.addAttribute("blogList",blogList);
        return "/view";
    }
   @GetMapping("/creatBlog")
   public String createNewBlog(Model model){
       Blog blog = new Blog();
       model.addAttribute("blog",blog);
       model.addAttribute("categoryList",serviceCategory.getAll());
       return "/creat";
   }
   @PostMapping("/creatBlog")
    public String create(){
        return "redirect:/view";
   }
}
