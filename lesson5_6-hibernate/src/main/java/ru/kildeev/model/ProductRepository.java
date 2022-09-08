package ru.kildeev.model;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init(){
        this.insert(new Product("Hanuman","Black Tea", 350));
        this.insert(new Product("Planteur", "Coffee", 500));
        this.insert(new Product("Richman", "Green Tea", 200));
        this.insert(new Product("Sati", "Coffee", 400));
        this.insert(new Product("Greenfield Melisa", "Green Tea", 100));
        this.insert(new Product("Lipton Spicy Marrakesh", "Black Tea", 150));
        this.insert(new Product("Teatone", "Variable", 300));
    }

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product findById(Long id) {
        return productMap.get(id);
    }

    public void insert(Product product) {
        Long id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }

    public Product update(Product product){
        if (product.getId() == null) {
            product.setId(identity.incrementAndGet());
        }
        productMap.put(product.getId(), product);
        return product;
    }

    public void delete(Long id) {
        productMap.remove(id);
    }

}
