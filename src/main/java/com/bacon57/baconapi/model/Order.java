package com.bacon57.baconapi.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consecutive")
    private Long consecutive;

    @Column(name = "cycle")
    private Long cycle;

    @Column(name = "id_client")
    private Long idClient;

    @Column(name = "value")
    private BigDecimal valuee;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "deliverys")
    private int deliverys;

    @Column(name = "value_delivery")
    private int deliveryValue;

    @Column(name = "delivery_type")
    private int deliveryType;

    @Column(name = "note")
    private String note;

    @Column(name = "table_num")
    private int tableNUm;

    @Column(name = "id_waiter")
    private int idWaiter;

    @Column(name = "service")
    private boolean service;

    @Column(name = "service_perc")
    private BigDecimal servicePerc;

    @Column(name = "status")
    private int status;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orders_id")
    private Set<ProductOrder> products;

}
