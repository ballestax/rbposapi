package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.dto.CategoryDto;
import com.bacon57.baconapi.exception.ResourceNotFoundException;
import com.bacon57.baconapi.mapper.CategoryMapper;
import com.bacon57.baconapi.mapper.ProductMapper;
import com.bacon57.baconapi.model.Category;
import com.bacon57.baconapi.model.Product;
import com.bacon57.baconapi.repository.CategoryRepository;
import com.bacon57.baconapi.repository.ProductRepository;
import com.bacon57.baconapi.service.CategoryService;
import com.bacon57.baconapi.service.ProductService;
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
