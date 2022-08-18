package ru.kildeev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;
import ru.kildeev.product.Product;
import ru.kildeev.product.ProductRepository;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainApp {

    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        productRepository.init();
        System.out.println(productRepository);
        System.out.println(productRepository.findProduct(3L));

        ApplicationContext context = new AnnotationConfigApplicationContext("ru.kildeev");
        Cart cart = context.getBean("cart",Cart.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello from CartApplication");
        while(true){
            System.out.println("You can use /add and /remove command");
            String command = scanner.next();
            System.out.println("Select product id");
            Long id = Long.valueOf(scanner.next());
            if (command.equals("/add")){
                cart.addProductInCart(id);
            } else if (command.equals("/remove")) {
                cart.removeProductFromCart(id);
            } else if (command.equals("/stop")){
                break;
            }
//          switch (command) {
//              case "/add": cart.addProductInCart(Long.valueOf(id));
//              case "/remove": cart.removeProductFromCart(Long.valueOf(id));
//              case "/stop": break;
//          }
            System.out.println(cart);
            System.out.println("Waiting for your command");
        }

    }
}
