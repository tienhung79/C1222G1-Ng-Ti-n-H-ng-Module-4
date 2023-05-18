package buildBlog.service.impl;

import buildBlog.model.Category;
import buildBlog.repository.IRepositoryCagetory;
import buildBlog.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory implements IServiceCategory {
    @Autowired
    private IRepositoryCagetory repositoryCagetoryBlog;
    @Override
    public List<Category> getAll() {
        return repositoryCagetoryBlog.findAll();
    }

    @Override
    public Category getById(int id) {
        return repositoryCagetoryBlog.findById(id).get();
    }

    @Override
    public void update(Category categoryBlog) {
         repositoryCagetoryBlog.save(categoryBlog);
    }

    @Override
    public void deleteById(int id) {
        repositoryCagetoryBlog.deleteById(id);
    }

    @Override
    public Iterable<Category> getAllCategory() {
        return repositoryCagetoryBlog.findAll();
    }
}
