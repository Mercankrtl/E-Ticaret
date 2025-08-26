package com.eticaret.backend.service;

import com.eticaret.backend.model.ProductRecommendation;
import com.eticaret.backend.repository.ProductRecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRecommendationService {

    @Autowired
    private ProductRecommendationRepository recommendationRepository;

    // Tüm önerileri getir
    public List<ProductRecommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    // ID'ye göre öneri getir
    public Optional<ProductRecommendation> getRecommendationById(Integer id) {
        return recommendationRepository.findById(id);
    }

    // Yeni öneri oluştur
    public ProductRecommendation createRecommendation(ProductRecommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    // Öneriyi güncelle
    public ProductRecommendation updateRecommendation(ProductRecommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    // Öneriyi sil
    public void deleteRecommendation(Integer id) {
        recommendationRepository.deleteById(id);
    }

    // Belirli bir ürünün önerilerini getir
    public List<ProductRecommendation> getRecommendationsByProductId(Integer productId) {
        return recommendationRepository.findByProductId(productId);
    }
}
