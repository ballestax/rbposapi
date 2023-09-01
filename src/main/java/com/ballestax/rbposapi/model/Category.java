package com.ballestax.rbposapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "z_order")
    private int zOrder;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;

}
