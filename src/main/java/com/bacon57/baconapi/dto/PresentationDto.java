package com.bacon57.baconapi.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PresentationDto {

    private String name;
    private BigDecimal price;
    private boolean _deafult;
}
