package ru.kildeev.repository;

import lombok.NoArgsConstructor;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import ru.kildeev.model.Product;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;


@Repository
@NoArgsConstructor
public class L5ProductRepository {

    private EntityManagerFactory emFactory;
    private EntityManager entityManager;


    @PostConstruct
    public void init() {
        emFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();

//      entityManager.persist(new Product("Teatone", "black", 500));
//      entityManager.persist(new Product("Greenfield", "green", 300));
//      entityManager.persist(new Product("Lipton", "yellow", 200));

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Product> findAll() {
        entityManager = emFactory.createEntityManager();
        List<Product> products = entityManager.createQuery("select p from Product p", Product.class).getResultList();
        entityManager.close();
        return products;
    }

    public Product findById(Long id) {
        entityManager = emFactory.createEntityManager();
        Product product = entityManager.find(Product.class, id);
        entityManager.close();
        return product;
    }

    public void insert(Product product) {
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Product update(Product product) {
        entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    public void delete(Long id) {
        entityManager = emFactory.createEntityManager();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.close();
    }
}
