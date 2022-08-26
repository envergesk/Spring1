package ru.kildeev.persist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@RequiredArgsConstructor
public class Product {

    private Long id;

    @NotBlank(message = "Должно быть указано имя продукта")
    private String title;

    @NotBlank(message = "Должно быть указано имя продукта")
    private String type;

    private Integer cost;

    public Product(String title, String type, Integer cost) {
        this.title = title;
        this.type = type;
        this.cost = cost;
    }

    public Product(String title) {
    }
}
