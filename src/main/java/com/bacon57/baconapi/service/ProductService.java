package com.bacon57.baconapi.service;

import com.bacon57.baconapi.model.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product updateProduct(Product product, long id);

    void delete(long id);
}
