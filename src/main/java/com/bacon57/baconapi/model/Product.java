package com.bacon57.baconapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description", length = 512)
    private String description;

    @Column(name = "price", precision = 8)
    private double price;

    @Column(name = "variable", columnDefinition = "0")
    private boolean variable;

    @Column(name = "enabled", columnDefinition = "1")
    private boolean enabled;




}
