package com.bacon57.baconapi.controller;

import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.model.ProductIngredient;
import com.bacon57.baconapi.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") long productId){
        return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") long id){
        productService.delete(id);
        return new ResponseEntity<String>("Product deleted successfully!", HttpStatus.OK);
    }

}
