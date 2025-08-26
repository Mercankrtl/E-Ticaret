// src/main/java/com/eticaret/backend/service/ProductRecommendationService.java
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

    public List<ProductRecommendation> getAllRecommendations() { return recommendationRepository.findAll(); }
    public Optional<ProductRecommendation> getRecommendationById(Long id) { return recommendationRepository.findById(id); }
    public ProductRecommendation createRecommendation(ProductRecommendation recommendation) { return recommendationRepository.save(recommendation); }
    public ProductRecommendation updateRecommendation(ProductRecommendation recommendation) { return recommendationRepository.save(recommendation); }
    public void deleteRecommendation(Long id) { recommendationRepository.deleteById(id); }
    public List<ProductRecommendation> getRecommendationsByProductId(Long productId) { return recommendationRepository.findByProduct_Id(productId); }
}
