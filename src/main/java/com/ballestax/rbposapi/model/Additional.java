package com.ballestax.rbposapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "additionals")
public class Additional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @JsonBackReference
    @ManyToMany(mappedBy = "additionals", fetch = FetchType.LAZY)
    private Set<Product> products;
}
