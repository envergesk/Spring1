package ru.kildeev.repository;

import ru.kildeev.model.Customer;
import ru.kildeev.model.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private L6EntityManagerFactory entityManagerFactory;

    public ProductDaoImpl(L6EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Product findById(Long id) {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        List<Product> products = entityManager.createQuery("select p from Product p").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return products;
    }

    @Override
    public Long countProducts() {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Long count = entityManager.createQuery("select count(p) from Product p", Long.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return count;
    }

    @Override
    public void saveProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        if (product.getId() == null) {
            entityManager.persist(product);
        } else {
            entityManager.merge(product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteProduct(Product product) {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Customer> findCustomersWithThisProduct(Product product) {
        return null;
    }
}
