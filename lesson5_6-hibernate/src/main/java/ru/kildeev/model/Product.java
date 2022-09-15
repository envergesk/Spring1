package ru.kildeev.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Должно быть указано имя продукта")
    @Column(name="title", nullable = false)
    private String title;

    @NotBlank(message = "Должно быть указано имя продукта")
    @Column(name="type", nullable = false)
    private String type;

    @Min(message = "Стоимость не может быть ниже 100", value = 100)
    //@Pattern(regexp = "[\\s]*[0-9]",message="Должны быть указаны цифры")
    @Column(name="cost", nullable = false)
    private Integer cost;

    @ManyToOne
    private Customer customer;

    @OneToMany
    private List<Customer> customers;

    public Product(String title, String type, Integer cost) {
        this.title = title;
        this.type = type;
        this.cost = cost;
    }

    public Product(String title) {
    }
}
