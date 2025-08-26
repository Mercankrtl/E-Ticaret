package com.eticaret.backend.service;

import com.eticaret.backend.model.Product;
import com.eticaret.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Tüm ürünleri getir
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // ID'ye göre ürün getir
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    // Yeni ürün oluştur
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // Ürünü güncelle
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    // Ürünü sil
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    // Kategoriye göre ürünleri getir
    public List<Product> getProductsByCategoryId(Integer categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    // Cinsiyete göre ürünleri getir
    public List<Product> getProductsByGenderId(Integer genderId) {
        return productRepository.findByGenderId(genderId);
    }

    // Yeni ek fonksiyonlar eklenebilir (örn. en çok satan, yeni ürünler)
}
