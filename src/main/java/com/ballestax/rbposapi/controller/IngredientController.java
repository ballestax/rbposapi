package com.ballestax.rbposapi.controller;

import com.ballestax.rbposapi.dto.IngredientDto;
import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.service.IngredientService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Ingredient> saveIngredient(@RequestBody Ingredient ingredient){
        return new ResponseEntity<>(ingredientService.saveIngredient(ingredient), HttpStatus.CREATED);
    }

    @GetMapping
    public List<IngredientDto> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }


}
