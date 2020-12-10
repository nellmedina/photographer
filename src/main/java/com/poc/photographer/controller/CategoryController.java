package com.poc.photographer.controller;

import com.poc.photographer.model.Category;
import com.poc.photographer.service.CategoryService;
import com.poc.photographer.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;


@RestControllerAdvice
@RequestMapping("/categories")
public class CategoryController
{
    private ICategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories()
    {
        return categoryService.getCategories();
    }
}
