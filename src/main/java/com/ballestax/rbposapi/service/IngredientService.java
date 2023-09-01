package com.ballestax.rbposapi.service;

import com.ballestax.rbposapi.dto.IngredientDto;
import com.ballestax.rbposapi.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient product);

    List<Ingredient> getAllIngredients();

    List<Ingredient> getAllIngredientsByProductId(Long productId);

    Ingredient getIngredientById(long id);

    Ingredient updateIngredient(Ingredient product, long id);

    void delete(long id);

}
