package ru.kildeev.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = """
           select * from products p 
           where (:productFilter is null or p.title like :productFilter)
           and (:typeFilter is null or p.type like :typeFilter)
           and (:minCost is null or p.cost >= :minCost)
           and (:maxCost is null or p.cost <= :maxCost)
           """, nativeQuery = true)
    List<Product> productByFilter(String productFilter, String typeFilter, String minCost, String maxCost);
}
