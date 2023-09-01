package com.ballestax.rbposapi.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<Product> products;

}
