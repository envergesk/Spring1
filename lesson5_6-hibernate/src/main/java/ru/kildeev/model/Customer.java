package ru.kildeev.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.kildeev.repository.ProductDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE},
            orphanRemoval = true)
    private List<Product> products;

    @ManyToOne
    private Product product;
}
