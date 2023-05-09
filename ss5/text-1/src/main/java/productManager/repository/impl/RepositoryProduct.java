package productManager.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
        Session session = null;
        try {
            session = ConnentionUtil.sessionFactory.openSession();
           return session.createQuery("from Product where id = :id", Product.class).setParameter("id",id).getSingleResult();
        }catch (Exception exception){
            throw new RuntimeException(exception);
        }finally {
            session.close();
        }
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            Product product1 = getProductById(product.getId());
            session = ConnentionUtil.sessionFactory.openSession();
           transaction= session.beginTransaction();
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            session.update(product1);
            transaction.commit();
        }catch (Exception exception){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session!=null){
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            Product product = getProductById(id);
            session = ConnentionUtil.sessionFactory.
                    openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }catch (Exception exception){
           if (transaction!=null){
               transaction.rollback();
           }
        }finally {
            session.close();
        }
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnentionUtil.sessionFactory
                    .openSession();
            transaction= session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception exception){
            if (transaction!=null){
                transaction.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session =null;
        try {
            session = ConnentionUtil.sessionFactory.openSession();
           return session.createQuery("from Product where name like concat('%',:name,'%')", Product.class).setParameter("name", name).getResultList();
        }catch (Exception exception){
            throw new RuntimeException(exception);
        }finally {
            session.close();
        }
    }
}
