package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.model.Ingredient;
import com.bacon57.baconapi.repository.IngredientRepository;
import com.bacon57.baconapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient saveIngredient(Ingredient product) {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredientsByProductId(Long productId) {
        return ingredientRepository.findIngredientByProductId(productId);
    }

    @Override
    public Ingredient getIngredientById(long id) {
        return null;
    }

    @Override
    public Ingredient updateIngredient(Ingredient product, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
