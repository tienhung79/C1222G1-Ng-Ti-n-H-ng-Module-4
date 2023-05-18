package buildBlog.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cagetoryBlog;
    @OneToMany(mappedBy = "categoryBlog")
    @JsonBackReference
    private List<Blog> blogList;

    public Category() {
    }

    public Category(int id, String cagetoryBlog) {
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
