package buildBlog.service;

import buildBlog.model.Blog;

import java.awt.print.Pageable;
import java.util.List;

public interface IServiceBlog {
    List<Blog> getAllBlog();
     void creatBlog(Blog blog);

    Blog getBlogById(int id);

    void update(Blog blog);

    void deleteById(int id);


    Object getListBlog(Pageable pageable);
}
