package com.bacon57.baconapi.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "variable")
    private boolean variable;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<Presentation> presentations;


    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<ProductIngredient> productIngredients;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

}
