package com.ballestax.rbposapi.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.ballestax.rbposapi.model.Category;
import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.model.Product;
import com.github.javafaker.Faker;

@Service
public class FakeDataService {

    private final Faker faker = new Faker();

    public Category generateFakeCategory(){
        Category category = new Category();
        category.setName(faker.food().dish());
        category.setZOrder(1);
        return category;
    }

    public Product generateFakeProduct(){
        Product product = new Product();
        product.setName(faker.food().fruit());
        product.setCode(faker.code().asin());
        product.setDescription(faker.lorem().sentence(15));
        product.setPrice(new BigDecimal(5000));
        product.setVariable(false);
        product.setEnabled(true);
        return product;
    }

    public Ingredient generateFakeIngredient(){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(faker.food().ingredient());       
        return ingredient;
    }


    
}
