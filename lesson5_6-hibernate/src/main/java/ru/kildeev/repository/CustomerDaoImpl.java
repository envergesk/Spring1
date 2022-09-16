package ru.kildeev.repository;

import ru.kildeev.model.Customer;
import ru.kildeev.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private L6EntityManagerFactory entityManagerFactory;

    public CustomerDaoImpl(L6EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Customer findById(Long id) {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        List<Customer> customers = entityManager.createQuery("select c from Customer c").getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return customers;
    }

    @Override
    public Long countCustomers() {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        Long count = entityManager.createQuery("select count(c) from Customer c", Long.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return count;
    }

    @Override
    public void saveCustomer(Customer customer) {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        if (customer.getId() == null) {
            entityManager.persist(customer);
        } else {
            entityManager.merge(customer);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCustomer(Customer customer) {
        EntityManager entityManager = entityManagerFactory.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Product> findProductsOfCurrentCustomer(Long id) {
        return null;
    }
}
