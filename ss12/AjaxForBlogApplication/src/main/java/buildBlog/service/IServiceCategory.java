package buildBlog.service;

import buildBlog.model.Category;

import java.util.List;

public interface IServiceCategory {
    List<Category> getAll();

    Category getById(int id);

    void update(Category categoryBlog);

    void deleteById(int id);

    Iterable<Category> getAllCategory();
}
