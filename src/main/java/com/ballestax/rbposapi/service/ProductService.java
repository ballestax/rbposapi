package com.ballestax.rbposapi.service;

import com.ballestax.rbposapi.dto.ProductDto;
import com.ballestax.rbposapi.dto.ProductFullDto;
import com.ballestax.rbposapi.model.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Product saveProduct(Product product);

    List<ProductDto> getAllProducts();

    ProductFullDto getProductById(long id);

    Product updateProduct(Product product, long id);

    void delete(long id);

}
