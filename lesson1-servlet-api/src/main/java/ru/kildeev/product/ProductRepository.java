package ru.kildeev.product;

import ru.kildeev.persist.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    private final AtomicLong identity = new AtomicLong(0);

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public void insert(Product product){
        long id = identity.incrementAndGet();
        product.setId(id);
        productMap.put(id, product);
    }

    public void update(Product product){
        productMap.put(product.getId(), product);
    }

    public void delete(Product product){
        productMap.remove(product.getId());
    }
    public void delete(Long id){
        productMap.remove(id);
    }
}
