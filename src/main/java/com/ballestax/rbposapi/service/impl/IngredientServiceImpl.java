package com.ballestax.rbposapi.service.impl;

import com.ballestax.rbposapi.dto.IngredientDto;
import com.ballestax.rbposapi.exception.ResourceNotFoundException;
import com.ballestax.rbposapi.mapper.CategoryMapper;
import com.ballestax.rbposapi.mapper.IngredientMapper;
import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.model.Product;
import com.ballestax.rbposapi.repository.CategoryRepository;
import com.ballestax.rbposapi.repository.IngredientRepository;
import com.ballestax.rbposapi.repository.ProductRepository;
import com.ballestax.rbposapi.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private IngredientMapper mapper;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        super();
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public List<IngredientDto> getAllIngredients() {
        return ingredientRepository.findAll(Sort.by(Sort.Direction.DESC, "name"))
                .stream()
                .map(ingredient -> mapper.ingredientToIngredientDto(ingredient))
                .collect(Collectors.toList());
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

    @Override
    public boolean addIngredientToProduct(long idProduct, long idIngredient) {
        Product existingProduct = productRepository.findById(idProduct).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", idProduct)
        );
        Ingredient existingIngredient = ingredientRepository.findById(idIngredient).orElseThrow(
                () -> new ResourceNotFoundException("Ingredient", "id", idIngredient)
        );
        List<Ingredient> ingredients = existingProduct.getIngredients();
        ingredients.add(existingIngredient);
        existingProduct.setIngredients(ingredients);
        productRepository.save(existingProduct);        
        return true;
    }
}
