package com.ballestax.rbposapi.controller;

import com.ballestax.rbposapi.dto.CategoryDto;
import com.ballestax.rbposapi.model.Category;
import com.ballestax.rbposapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoryDto> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") long categoryId){
        return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
        return new ResponseEntity<Category>(categoryService.updateCategory(category, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") long id){
        categoryService.delete(id);
        return new ResponseEntity<String>("Category deleted successfully!", HttpStatus.OK);
    }

}
