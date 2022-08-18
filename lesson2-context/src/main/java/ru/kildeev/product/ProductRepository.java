package ru.kildeev.product;

import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();
    private final AtomicLong identity = new AtomicLong(0);

    @PostConstruct
    public void init(){
        String stringProducts = "bread 50 milk 100 choco 120 eggs 100 apples 70";
        String[] sp = stringProducts.split(" ");
        for (int i = 0; i < 5; i++) {
            Long id = identity.addAndGet(1);
            Product product = new Product(sp[i * 2], Integer.valueOf(sp[(i*2 + 1)]));
            product.setId(id);
            productMap.put(id, product);
        }
    }

    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    public Product findProduct(Long id){
        return productMap.get(id);
    }

    public void insert(Product product){
        Long id = identity.addAndGet(1);
        product.setId(id);
        productMap.put(id, product);
    }

    public void delete(Product product){
        productMap.remove(product.getId());
    }

    public void delete(Long id){
        productMap.remove(id);
    }
}
