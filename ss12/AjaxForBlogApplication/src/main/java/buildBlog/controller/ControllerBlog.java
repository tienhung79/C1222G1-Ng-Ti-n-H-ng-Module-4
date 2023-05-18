package buildBlog.controller;

import buildBlog.model.Blog;
import buildBlog.model.CategoryBlog;
import buildBlog.service.IServiceBlog;
import buildBlog.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class ControllerBlog {
    @Autowired
    IServiceCategory serviceCategory;
    @Autowired
    IServiceBlog serviceBlog;

    @GetMapping("/category")
    public ResponseEntity<List<CategoryBlog>> displayListCategory() {
        List<CategoryBlog> categoryBlogList = serviceCategory.getAll();
        if (categoryBlogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryBlogList, HttpStatus.OK);
        }
    }

    @GetMapping("/blog")
    public ResponseEntity<Page<Blog>> getAll(@RequestParam(value = "page") int page, @PageableDefault(size = 1) Pageable pageable){
        Page<Blog> blogs = serviceBlog.findAllPage(PageRequest.of(0, page));
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogbyCategory/{nameCategory}")
    public ResponseEntity<List<Blog>> displayBlogByCategory(@PathVariable(value = "nameCategory") String nameCategory) {
        List<Blog> blogList = serviceBlog.getAllBlogByCategory(nameCategory);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogList, HttpStatus.OK);
        }
    }

    @GetMapping("/blogById/{id}")
    public ResponseEntity<Blog> displayBlogById(@PathVariable(value = "id") int id) {
        Blog blog = serviceBlog.getBlogById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blog, HttpStatus.OK);
        }
    }




}
