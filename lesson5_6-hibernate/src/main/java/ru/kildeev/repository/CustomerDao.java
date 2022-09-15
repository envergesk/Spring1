package ru.kildeev.repository;

import ru.kildeev.model.Customer;
import ru.kildeev.model.Product;

import java.util.List;

public interface CustomerDao {

    Customer findById(Long id);

    List<Customer> findAll();

    Long countCustomers();

    void saveCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    List<Product> findProductsOfCurrentCustomer(Long id);

}
