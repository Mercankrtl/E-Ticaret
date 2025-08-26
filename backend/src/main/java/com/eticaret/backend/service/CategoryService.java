// src/main/java/com/eticaret/backend/service/CategoryService.java
package com.eticaret.backend.service;

import com.eticaret.backend.model.Category;
import com.eticaret.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() { return categoryRepository.findAll(); }
    public Optional<Category> getCategoryById(Long id) { return categoryRepository.findById(id); }
    public Category createCategory(Category category) { return categoryRepository.save(category); }
    public Category updateCategory(Category category) { return categoryRepository.save(category); }
    public void deleteCategory(Long id) { categoryRepository.deleteById(id); }
    public Optional<Category> getCategoryByName(String name) { return categoryRepository.findByName(name); }
}
