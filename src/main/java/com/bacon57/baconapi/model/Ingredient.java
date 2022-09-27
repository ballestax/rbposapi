package com.bacon57.baconapi.model;

import javax.persistence.*;
import java.util.Set;

public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "optional")
    private boolean optional;

    @OneToMany(mappedBy = "ingredient")
    private Set<ProductIngredient> productIngredients;

}
