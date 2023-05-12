package buildBlog.service;

import buildBlog.model.CategoryBlog;

import java.util.List;

public interface IServiceCategory {
    List<CategoryBlog> getAll();

    CategoryBlog getById(int id);

    void update(CategoryBlog categoryBlog);

    void deleteById(int id);
}
