package com.ballestax.rbposapi.service;

import org.springframework.stereotype.Service;

import com.ballestax.rbposapi.repository.CategoryRepository;
import com.ballestax.rbposapi.repository.IngredientRepository;
import com.ballestax.rbposapi.repository.ProductRepository;

@Service
public class DataPopulationService {
    
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;
    private IngredientRepository ingredientRepository;
    private FakeDataService fakeDataService;

    public DataPopulationService(ProductRepository productRepository, IngredientRepository ingredientRepository, CategoryRepository categoryRepository, FakeDataService fakeDataService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.fakeDataService = fakeDataService;
    }

    public void populateCategories(int numberOfCategories) {
        for (int i = 0; i < numberOfCategories; i++) {
            categoryRepository.save(fakeDataService.generateFakeCategory());
        }
    }

    public void populateProducts(int numberOfProducts) {
        for (int i = 0; i < numberOfProducts; i++) {
            productRepository.save(fakeDataService.generateFakeProduct());
        }
    }

    public void populateIngredients(int numberOfIngredients) {
        for (int i = 0; i < numberOfIngredients; i++) {
            ingredientRepository.save(fakeDataService.generateFakeIngredient());
        }
    }


}
