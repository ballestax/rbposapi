package com.ballestax.rbposapi.dto;

import com.ballestax.rbposapi.model.Additional;
import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.model.Presentation;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class ProductFullDto {

    private String name;
    private String category;
    private String image;
    private BigDecimal price;
    private boolean variable;
    private List<Presentation> presentations;
    private Set<Ingredient> ingredients;
    private Set<Additional> additionals;


}
