package ru.kildeev;

import ru.kildeev.product.Product;
import ru.kildeev.product.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        this.productRepository.insert(new Product("Milk", 90));
        this.productRepository.insert(new Product("Apples", 80));
        this.productRepository.insert(new Product("Bread", 50));
        this.productRepository.insert(new Product("Choco", 120));
        this.productRepository.insert(new Product("Bananas", 90));
        this.productRepository.insert(new Product("Tomato", 200));
        this.productRepository.insert(new Product("Meat", 400));
        this.productRepository.insert(new Product("Potato", 50));
        this.productRepository.insert(new Product("Eggs", 100));
        this.productRepository.insert(new Product("Oil", 150));


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<td>id</td>");
        writer.println("<td>name</td>");
        writer.println("</tr>");

        for (Product product : productRepository.findAll()) {
            writer.println("<tr>");
            writer.println("<td>" + product.getId() + "</td>");
            writer.println("<td>" + product.getTitle() + "</td>");
            writer.println("</tr>");
        }
    }
}
