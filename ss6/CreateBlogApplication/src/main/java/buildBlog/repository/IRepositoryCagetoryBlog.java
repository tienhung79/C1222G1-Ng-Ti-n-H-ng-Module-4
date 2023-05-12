package buildBlog.repository;

import buildBlog.model.CategoryBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCagetoryBlog extends JpaRepository<CategoryBlog,Integer> {
}
