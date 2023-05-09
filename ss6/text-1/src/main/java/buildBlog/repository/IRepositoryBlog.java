package buildBlog.repository;

import buildBlog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {

}
