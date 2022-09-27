package com.bacon57.baconapi.model;

import javax.persistence.Column;
import java.io.Serializable;

public class ProductIngredientKey implements Serializable {

    @Column(name = "product_id")
    Long productId;

    @Column(name = "ingredient_id")
    Long ingredientId;


}
