package com.bacon57.baconapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "presentations")
public class Presentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "serie")
    private int serie;

    @Column(name = "price")
    private double price;

    @Column(name = "default")
    private boolean _default;

    @Column(name = "enabled")
    private boolean _enabled;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;
}
