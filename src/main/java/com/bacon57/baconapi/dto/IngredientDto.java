package com.bacon57.baconapi.dto;

import lombok.Data;

@Data
public class IngredientDto {

    private String name;
    private double quantity;
    private boolean optional;

}
