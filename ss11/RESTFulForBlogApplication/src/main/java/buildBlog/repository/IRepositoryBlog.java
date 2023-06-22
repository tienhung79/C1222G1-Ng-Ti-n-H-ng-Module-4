package buildBlog.repository;

import buildBlog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {

    @Query(value = "select * from blog join category on blog.cagetory_id=category.id where cagetory_blog = ?",nativeQuery = true)
    List<Blog> findAllByNameCategory(String nameCategory);
}
