package buildBlog.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CategoryBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cagetoryBlog;
    @OneToMany(mappedBy = "categoryBlog")
    private List<Blog> blogList;

    public CategoryBlog() {
    }

    public CategoryBlog(int id, String cagetoryBlog) {
        this.id = id;
        this.cagetoryBlog = cagetoryBlog;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCagetoryBlog() {
        return cagetoryBlog;
    }

    public void setCagetoryBlog(String cagetoryBlog) {
        this.cagetoryBlog = cagetoryBlog;
    }
}
