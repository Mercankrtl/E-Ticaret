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

    // Tüm kategorileri getir
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // ID'ye göre kategori getir
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    // Yeni kategori ekle
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Kategori güncelle
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Kategori sil
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    // İsim ile arama (opsiyonel)
    public Optional<Category> getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
