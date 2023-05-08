package productManager.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;

public class ConnentionUtil {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;
    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
