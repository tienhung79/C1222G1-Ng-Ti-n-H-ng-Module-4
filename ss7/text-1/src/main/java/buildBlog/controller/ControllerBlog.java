package buildBlog.controller;

import buildBlog.model.Blog;
import buildBlog.service.IServiceBlog;
import buildBlog.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class ControllerBlog {
    @Autowired
   private IServiceBlog serviceBlog;
    @Autowired
    private IServiceCategory serviceCategory;
    @GetMapping("/blogHome")
    public String disPlayBlog(Model model, @PageableDefault(size = 1)Pageable pageable){
//        Pageable<Blog> blogList = serviceBlog.getAllBlog(pageable);
//        model.addAttribute("blogList",blogList);
        model.addAttribute("blogList",serviceBlog.getListBlog(pageable));
        return "/view";
    }
   @GetMapping("/creatBlog")
   public String createNewBlog(Model model){
       Blog blog = new Blog();
       model.addAttribute("blog",blog);
       model.addAttribute("categoryList",serviceCategory.getAll());
       return "/create";
   }
   @PostMapping("/creatBlog")
    public String create(Blog blog){
        serviceBlog.creatBlog(blog);
        return "redirect:/blog/blogHome";
   }
   @GetMapping("/{id}/updateBlog")
    public String updateBlog(Model model, @PathVariable(value = "id",required = false) int id){
       Blog blog = serviceBlog.getBlogById(id);
       model.addAttribute("categoryList",serviceCategory.getAll());
       model.addAttribute("blog",blog);
        return "/updateBlog";
   }
   @PostMapping("/update")
    public String update(Blog blog){
        serviceBlog.update(blog);
       return "redirect:/blog/blogHome";
   }
   @GetMapping("/delete")
    public String deleteById(@RequestParam(value = "id") int id){
        serviceBlog.deleteById(id);
       return "redirect:/blog/blogHome";
   }
//   @GetMapping("/searchByName")
//    public String searchByName(@RequestParam(value = "name") String name,Model model){
//      List<Blog> blogList= serviceBlog.searchByName(name);
//       return "redirect:/blog/blogHome";
//   }
}
