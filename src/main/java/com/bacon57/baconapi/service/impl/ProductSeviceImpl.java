package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.exception.ResourceNotFoundException;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.repository.ProductRepository;
import com.bacon57.baconapi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSeviceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductSeviceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Product", "id", id));
    }

    @Override
    public Product updateProduct(Product product, long id) {
        Product existingProduct = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id)
        );
        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setVariable(product.isVariable());
        existingProduct.setEnabled(product.isEnabled());

        productRepository.save(existingProduct);
        return existingProduct;
    }

    @Override
    public void delete(long id) {
        productRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }
}
