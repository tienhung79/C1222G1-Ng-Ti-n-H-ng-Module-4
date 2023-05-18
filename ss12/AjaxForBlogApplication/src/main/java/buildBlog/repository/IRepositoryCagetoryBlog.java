package buildBlog.repository;

import buildBlog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCagetoryBlog extends JpaRepository<Category,Integer> {
}
