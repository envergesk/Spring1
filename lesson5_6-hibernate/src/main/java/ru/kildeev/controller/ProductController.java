package ru.kildeev.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kildeev.model.L5ProductRepository;
import ru.kildeev.model.Product;
import ru.kildeev.model.ProductRepository;


import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final L5ProductRepository productRepository;

    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") long id){
        productRepository.delete(id);
        return "redirect:/product";
    }


    @PostMapping
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        log.info("Method saveProduct was hit");
        productRepository.update(product);
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product){
        productRepository.update(product);
        return "redirect:/product";
    }


    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product(""));
        return "product_form";
    }

}
