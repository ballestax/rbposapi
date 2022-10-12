package com.bacon57.baconapi.service;

import com.bacon57.baconapi.dto.IngredientDto;
import com.bacon57.baconapi.model.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient saveIngredient(Ingredient product);

    List<Ingredient> getAllIngredients();

    List<Ingredient> getAllIngredientsByProductId(Long productId);

    Ingredient getIngredientById(long id);

    Ingredient updateIngredient(Ingredient product, long id);

    void delete(long id);

}
