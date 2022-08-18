package ru.kildeev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.kildeev.product.Product;
import ru.kildeev.product.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> productsInCart;
    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        this.productsInCart = new ArrayList<>();
    }

    public void addProductInCart(Long id) {
        productsInCart.add(productRepository.findProduct(id));
//       if (productsInCart.stream().filter(p -> p.getId().equals(id)).findFirst().equals(id)){
//           productsInCart.add(productRepository.findProduct(id));
//       } else {
//           System.err.println("There are no such product in Product Repository");
//       }

    }

    public void removeProductFromCart(Long id) {
        if (productsInCart.stream().filter(p -> p.getId().equals(id)).findFirst().equals(id)) {
            productsInCart.remove(productRepository.findProduct(id));
        } else {
            System.err.println("Have no product with id " + id + " in this cart");
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "productsInCart=" + productsInCart +
                '}';
    }
}
