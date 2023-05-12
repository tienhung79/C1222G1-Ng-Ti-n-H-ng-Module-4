package buildBlog.controller;

import buildBlog.model.Blog;
import buildBlog.model.CategoryBlog;
import buildBlog.service.IServiceCategory;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cagetory")
public class ControllerCategoryBlog {
    @Autowired
    private IServiceCategory serviceCategory;
    @GetMapping("")
    public String disPlayCatogory(Model model){
        List<CategoryBlog> categoryBlogList = serviceCategory.getAll();
        model.addAttribute("categoryBlogList",categoryBlogList);
        return "/categoryHome";
    }
    @GetMapping("/update/{id}")
    public String updateCategory(Model model, @PathVariable int id){
        CategoryBlog categoryBlog = serviceCategory.getById(id);
        model.addAttribute("category",categoryBlog);
        return "/updateCategory";
    }
    @PostMapping("/update")
    public String update(CategoryBlog categoryBlog){
        serviceCategory.update(categoryBlog);
        return "redirect:/cagetory";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam(value = "idDelete") int id){
        serviceCategory.deleteById(id);
        return "redirect:/cagetory";
    }
}
