package com.bacon57.baconapi.controller;

import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.dto.ProductFullDto;
import com.bacon57.baconapi.model.Additional;
import com.bacon57.baconapi.model.Ingredient;
import com.bacon57.baconapi.model.Presentation;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.service.AdditionalService;
import com.bacon57.baconapi.service.IngredientService;
import com.bacon57.baconapi.service.PresentationService;
import com.bacon57.baconapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private AdditionalService additionalService;

    @Autowired
    private PresentationService presentationService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductFullDto> getProductById(@PathVariable("id") long productId) {
        return new ResponseEntity<>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return new ResponseEntity<>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id) {
        productService.delete(id);
        return new ResponseEntity<>("Product deleted successfully!", HttpStatus.OK);
    }

    @GetMapping("{id}/ingredients")
    public List<Ingredient> getIngredientsByProductId(@PathVariable("id") long id) {
        if (ingredientService == null) {
            return Collections.emptyList();
        }
        return ingredientService.getAllIngredientsByProductId(id);
    }

    @GetMapping("{id}/additions")
    public List<Additional> getAdditionsByProductId(@PathVariable("id") long id) {
        if (additionalService == null) {
            return Collections.emptyList();
        }
        return additionalService.getAllAdditionalsByProductId(id);
    }

    @GetMapping("{id}/presentations")
    public List<Presentation> getPresentationsByProductId(@PathVariable("id") long id) {
        if (presentationService == null) {
            return Collections.emptyList();
        }
        return presentationService.getAllPresentationsByProductId(id);
    }

}
