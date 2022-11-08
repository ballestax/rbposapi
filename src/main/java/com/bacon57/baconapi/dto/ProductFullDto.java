package com.bacon57.baconapi.dto;

import com.bacon57.baconapi.model.Additional;
import com.bacon57.baconapi.model.Ingredient;
import com.bacon57.baconapi.model.Presentation;
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
