package ru.kildeev.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kildeev.persist.Product;
import ru.kildeev.persist.ProductRepository;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public String listPage(@RequestParam(required = false) String productFilter,
                           @RequestParam(required = false) String typeFilter,
                           @RequestParam(required = false) String minCostFilter,
                           @RequestParam(required = false) String maxCostFilter,
                           Model model) {
        productFilter = productFilter == null || productFilter.isBlank() ? null : "%" + productFilter.trim() + "%";
        typeFilter = typeFilter == null || typeFilter.isBlank() ? null : "%" + typeFilter.trim() + "%";
        minCostFilter = minCostFilter == null || minCostFilter.isBlank() ? null : minCostFilter;
        maxCostFilter = maxCostFilter == null || maxCostFilter.isBlank() ? null : maxCostFilter;
        model.addAttribute("products", productRepository.productByFilter(productFilter, typeFilter, minCostFilter, maxCostFilter));
        return "product";
    }

    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") Long id){
        productRepository.deleteById(id);
        return "redirect:/product";
    }


    @PostMapping
    public String saveProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product_form";
        }
        log.info("Method saveProduct was hit");
        productRepository.save(product);
        return "redirect:/product";
    }

    @PostMapping("/update")
    public String updateProduct(Product product){
        productRepository.save(product);
        return "redirect:/product";
    }


    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product(""));
        return "product_form";
    }

}
