package ru.kildeev.repository;

import ru.kildeev.model.Customer;
import ru.kildeev.model.Product;

import java.util.List;

public interface ProductDao {

    Product findById(Long id);

    List<Product> findAll();

    Long countProducts();

    void saveProduct(Product product);

    void deleteProduct(Product product);

    List<Customer> findCustomersWithThisProduct(Product product);

}
