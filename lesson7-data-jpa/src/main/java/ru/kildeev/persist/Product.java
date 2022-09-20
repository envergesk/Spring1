package ru.kildeev.persist;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
@Table(name="products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Должно быть указано описание продукта")
    @Column(nullable = false, name = "title", unique = true)
    private String title;

    @NotBlank(message = "Должно быть указано имя продукта")
    @Column(nullable = false, name = "type")
    private String type;

    @Min(message = "Стоимость не может быть ниже 100", value = 100)
    //@Pattern(regexp = "[\\s]*[0-9]",message="Должны быть указаны цифры")
    @Column(nullable = false, name="cost")
    private Integer cost;

    public Product(String title, String type, Integer cost) {
        this.title = title;
        this.type = type;
        this.cost = cost;
    }

    public Product(String name) {
    }
}
