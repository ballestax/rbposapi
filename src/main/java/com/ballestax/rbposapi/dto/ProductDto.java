package com.ballestax.rbposapi.dto;

import com.ballestax.rbposapi.model.Presentation;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {

    private long id;
    private String name;
    private String category;
    private BigDecimal price;
    private String image;

}
