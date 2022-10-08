package com.bacon57.baconapi.service.impl;


import com.bacon57.baconapi.dto.ProductDto;
import com.bacon57.baconapi.dto.ProductFullDto;
import com.bacon57.baconapi.exception.ResourceNotFoundException;
import com.bacon57.baconapi.mapper.ProductMapper;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.model.ProductIngredient;
import com.bacon57.baconapi.repository.ProductRepository;
import com.bacon57.baconapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public
class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    @Autowired
    private ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(product -> mapper.entityToDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductFullDto getProductById(long id) {
        return productRepository.findById(id).map(product -> mapper.productToProductFullDto(product)).orElseThrow(()->
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


    public Set<ProductIngredient> getProductIngredientsById(long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "id", id)
        );

        return product.getProductIngredients();
    }
}
