package com.ballestax.rbposapi.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


@Data
@Entity
@Table(name = "order_product")
public class ProductOrder {

    @Id
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Presentation presentation;

//    private List<Additional> additionals;
//    private List<Ingredient> exclusions;


    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

}
