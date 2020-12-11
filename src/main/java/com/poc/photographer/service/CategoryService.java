package com.poc.photographer.service;

import com.poc.photographer.model.Category;
import com.poc.photographer.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService
{
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getCategories()
    {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    @Override
    public Category save(Category category)
    {
        return categoryRepository.save(category);
    }
}
