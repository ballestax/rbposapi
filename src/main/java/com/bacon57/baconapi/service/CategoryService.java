package com.bacon57.baconapi.service;

import com.bacon57.baconapi.model.Category;

import java.util.List;

public interface CategoryService {

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(long id);

    Category updateCategory(Category category, long id);

    void delete(long id);
}
