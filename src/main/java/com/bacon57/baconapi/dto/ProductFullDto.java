package com.bacon57.baconapi.dto;

import com.bacon57.baconapi.model.Presentation;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductFullDto {

    private String name;
    private String category;
    private BigDecimal price;
    private boolean variable;
    private List<Presentation> presentations;

}
