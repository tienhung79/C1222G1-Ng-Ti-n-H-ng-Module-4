package buildBlog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nameBlog;
    private String contentBlog;

    @ManyToOne
    @JoinColumn(name = "cagetory_id",referencedColumnName = "id")
    private Category categoryBlog;
    public Blog() {
    }

    public Blog(int id, String nameBlog, String contentBlog) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
    }

    public Blog(int id, String nameBlog, String contentBlog, Category categoryBlog) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.contentBlog = contentBlog;
        this.categoryBlog = categoryBlog;
    }

    public Category getCategoryBlog() {
        return categoryBlog;
    }

    public void setCategoryBlog(Category categoryBlog) {
        this.categoryBlog = categoryBlog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContentBlog() {
        return contentBlog;
    }

    public void setContentBlog(String contentBlog) {
        this.contentBlog = contentBlog;
    }
}