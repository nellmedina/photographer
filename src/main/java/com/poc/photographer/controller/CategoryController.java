package com.poc.photographer.controller;

import com.poc.photographer.model.Category;
import com.poc.photographer.service.CategoryService;
import com.poc.photographer.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
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

    @PostMapping
    public Category createCategory(@RequestBody Category category)
    {
        return categoryService.save(category);
    }
}
