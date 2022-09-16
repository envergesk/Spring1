package ru.kildeev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kildeev.repository.ProductDao;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="line_items")
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    private Long quantity;

    private String color;

    private String size;

}
