package buildBlog.repository;

import buildBlog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRepositoryBlog extends JpaRepository<Blog,Integer> {

    @Query(value = "select * from blog join category_blog on blog.cagetory_id=category_blog.id where name like (?)",nativeQuery = true)
    List<Blog> findAllByNameCategory(String nameCategory);
}