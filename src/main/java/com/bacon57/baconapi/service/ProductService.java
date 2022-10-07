package com.bacon57.baconapi.service;

import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.model.ProductIngredient;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product saveProduct(Product product);

    List<ProductDto> getAllProducts();

    Product getProductById(long id);

    Product updateProduct(Product product, long id);

    void delete(long id);

    Set<ProductIngredient> getProductIngredientsById(long id);
}
