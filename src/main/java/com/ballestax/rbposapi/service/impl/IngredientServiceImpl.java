package com.ballestax.rbposapi.service.impl;

import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.repository.IngredientRepository;
import com.ballestax.rbposapi.service.IngredientService;
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
