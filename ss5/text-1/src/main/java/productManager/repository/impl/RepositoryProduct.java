package productManager.repository.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import productManager.config.ConnentionUtil;
import productManager.model.Product;
import productManager.repository.IRepositoryProduct;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryProduct implements IRepositoryProduct {
    @Override
    public List<Product> getAll() {
        Session  session = null;
        try {
            session = ConnentionUtil.sessionFactory.openSession();
            return session.createQuery("from Product ", Product.class).getResultList();
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            if (session!=null){
                session.close();
            }
        }
        return null;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void update(Product product) {
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void create(Product product) {

    }
}
