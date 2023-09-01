package com.ballestax.rbposapi.dto;

import lombok.Data;

@Data
public class IngredientDto {

    private String name;
    private double quantity;
    private boolean optional;

}
