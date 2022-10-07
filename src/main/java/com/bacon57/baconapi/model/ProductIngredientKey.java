package com.bacon57.baconapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@EqualsAndHashCode
public class ProductIngredientKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "ingredient_id")
    Long ingredientId;


}
