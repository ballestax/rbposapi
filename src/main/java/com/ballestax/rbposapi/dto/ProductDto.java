package com.ballestax.rbposapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String category;
    private BigDecimal price;
    private String image;

}
