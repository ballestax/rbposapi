package com.ballestax.rbposapi.service.impl;

import com.ballestax.rbposapi.dto.CategoryDto;
import com.ballestax.rbposapi.exception.ResourceNotFoundException;
import com.ballestax.rbposapi.mapper.CategoryMapper;
import com.ballestax.rbposapi.mapper.ProductMapper;
import com.ballestax.rbposapi.model.Category;
import com.ballestax.rbposapi.model.Product;
import com.ballestax.rbposapi.repository.CategoryRepository;
import com.ballestax.rbposapi.repository.ProductRepository;
import com.ballestax.rbposapi.service.CategoryService;
import com.ballestax.rbposapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        return categoryRepository.findAll(Sort.by(Sort.Direction.DESC, "zOrder"))
                .stream()
                .map(category -> mapper.entityToDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Category", "id", id));
    }

    @Override
    public Category updateCategory(Category category, long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", id)
        );
        existingCategory.setName(category.getName());

        categoryRepository.save(existingCategory);
        return existingCategory;
    }

    @Override
    public void delete(long id) {
        categoryRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category", "Id", id));
        categoryRepository.deleteById(id);
    }
}
