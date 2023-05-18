package buildBlog.repository;

import buildBlog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryCagetory extends JpaRepository<Category,Integer> {
}
