package com.ballestax.rbposapi.service;

import com.ballestax.rbposapi.dto.CategoryDto;
import com.ballestax.rbposapi.model.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<CategoryDto> getAllCategories();

    Category getCategoryById(long id);

    Category updateCategory(Category category, long id);

    void delete(long id);
}
