package buildBlog.service;

import buildBlog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceBlog {
    List<Blog> getAllBlog();
     void creatBlog(Blog blog);

    Blog getBlogById(int id);

    void update(Blog blog);

    void deleteById(int id);

    Page<Blog> getBlogPage(Pageable pageable);

    List<Blog> getAllBlogByCategory(String nameCategory);
}
