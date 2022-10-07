package com.bacon57.baconapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "isdefault")
    private boolean _default;

    @Column(name = "isenabled")
    private boolean _enabled;

    @ManyToOne
    @JoinColumn(name ="product_id")
    @JsonBackReference
    private Product product;
}
