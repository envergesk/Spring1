package ru.kildeev.persist;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
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

    @Min(message = "Стоимость не может быть ниже 100", value = 100)
    //@Pattern(regexp = "[\\s]*[0-9]",message="Должны быть указаны цифры")
    private Integer cost;

    public Product(String title, String type, Integer cost) {
        this.title = title;
        this.type = type;
        this.cost = cost;
    }

    public Product(String title) {
    }
}
