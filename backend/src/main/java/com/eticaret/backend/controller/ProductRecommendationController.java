package com.eticaret.backend.controller;

import com.eticaret.backend.model.ProductRecommendation;
import com.eticaret.backend.service.ProductRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-recommendations")
public class ProductRecommendationController {

    @Autowired
    private ProductRecommendationService productRecommendationService;

    // Tüm önerileri getir
    @GetMapping
    public List<ProductRecommendation> getAllRecommendations() {
        return productRecommendationService.getAllRecommendations();
    }

    // ID ile öneri getir
    @GetMapping("/{id}")
    public ResponseEntity<ProductRecommendation> getRecommendationById(@PathVariable Integer id) {
        Optional<ProductRecommendation> recommendation = productRecommendationService.getRecommendationById(id);
        return recommendation.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni öneri oluştur
    @PostMapping
    public ProductRecommendation createRecommendation(@RequestBody ProductRecommendation recommendation) {
        return productRecommendationService.createRecommendation(recommendation);
    }

    // Öneri güncelle
    @PutMapping("/{id}")
    public ResponseEntity<ProductRecommendation> updateRecommendation(@PathVariable Integer id, @RequestBody ProductRecommendation recommendationDetails) {
        Optional<ProductRecommendation> existingRecommendation = productRecommendationService.getRecommendationById(id);
        if (existingRecommendation.isPresent()) {
            ProductRecommendation recommendation = existingRecommendation.get();
            recommendation.setProduct(recommendationDetails.getProduct());
            recommendation.setRecommendedProduct(recommendationDetails.getRecommendedProduct());
            recommendation.setScore(recommendationDetails.getScore());
            ProductRecommendation updatedRecommendation = productRecommendationService.updateRecommendation(recommendation);
            return ResponseEntity.ok(updatedRecommendation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Öneri sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Integer id) {
        productRecommendationService.deleteRecommendation(id);
        return ResponseEntity.noContent().build();
    }
}
