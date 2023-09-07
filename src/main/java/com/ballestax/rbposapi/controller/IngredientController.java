package com.ballestax.rbposapi.controller;

import com.ballestax.rbposapi.dto.IngredientDto;
import com.ballestax.rbposapi.dto.ProductDto;
import com.ballestax.rbposapi.model.Category;
import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.service.CategoryService;
import com.ballestax.rbposapi.service.IngredientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {

    private IngredientService ingredientService;     

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping()
    public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient Ingredient){
        return new ResponseEntity<Ingredient>(ingredientService.saveIngredient(Ingredient), HttpStatus.CREATED);
    }

    @GetMapping
    public List<IngredientDto> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }


}
