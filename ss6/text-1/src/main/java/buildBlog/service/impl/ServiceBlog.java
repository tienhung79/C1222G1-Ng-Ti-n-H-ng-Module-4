package buildBlog.service.impl;

import buildBlog.repository.IRepositoryBlog;
import buildBlog.model.Blog;

import buildBlog.service.IServiceBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBlog implements IServiceBlog {
    @Autowired
   private IRepositoryBlog repositoryBlog;

    @Override
    public List<Blog> getAllBlog() {
        return repositoryBlog.findAll();
    }

    @Override
    public void creatBlog(Blog blog) {
        repositoryBlog.save(blog);
    }

    @Override
    public Blog getBlogById(int id) {
        return repositoryBlog.getById(id);
    }

    @Override
    public void update(Blog blog) {
        repositoryBlog.save(blog);
    }

    @Override
    public void deleteById(int id) {
        repositoryBlog.deleteById(id);
    }
}
