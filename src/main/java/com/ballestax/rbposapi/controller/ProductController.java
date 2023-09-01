package com.ballestax.rbposapi.controller;

import com.ballestax.rbposapi.dto.ProductDto;
import com.ballestax.rbposapi.dto.ProductFullDto;
import com.ballestax.rbposapi.model.Additional;
import com.ballestax.rbposapi.model.Ingredient;
import com.ballestax.rbposapi.model.Presentation;
import com.ballestax.rbposapi.model.Product;
import com.ballestax.rbposapi.service.AdditionalService;
import com.ballestax.rbposapi.service.IngredientService;
import com.ballestax.rbposapi.service.PresentationService;
import com.ballestax.rbposapi.service.ProductService;
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
