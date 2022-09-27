package com.bacon57.baconapi.model;

import javax.persistence.*;

@Entity
public class ProductIngredient {

    @EmbeddedId
    ProductIngredientKey id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(name = "ingredient_id")
    Ingredient ingredient;

    int cantidad;
    boolean optional;






}
