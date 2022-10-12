package com.bacon57.baconapi.service;

import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.dto.ProductFullDto;
import com.bacon57.baconapi.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product saveProduct(Product product);

    List<ProductDto> getAllProducts();

    ProductFullDto getProductById(long id);

    Product updateProduct(Product product, long id);

    void delete(long id);

}
