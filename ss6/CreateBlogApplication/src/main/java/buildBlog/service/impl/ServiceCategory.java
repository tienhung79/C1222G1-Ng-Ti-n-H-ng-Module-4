package buildBlog.service.impl;

import buildBlog.model.CategoryBlog;
import buildBlog.repository.IRepositoryCagetoryBlog;
import buildBlog.service.IServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory implements IServiceCategory {
    @Autowired
    private IRepositoryCagetoryBlog repositoryCagetoryBlog;
    @Override
    public List<CategoryBlog> getAll() {
        return repositoryCagetoryBlog.findAll();
    }

    @Override
    public CategoryBlog getById(int id) {
        return repositoryCagetoryBlog.findById(id).get();
    }

    @Override
    public void update(CategoryBlog categoryBlog) {
         repositoryCagetoryBlog.save(categoryBlog);
    }

    @Override
    public void deleteById(int id) {
        repositoryCagetoryBlog.deleteById(id);
    }
}
