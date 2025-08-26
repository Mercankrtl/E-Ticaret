// src/main/java/com/eticaret/backend/controller/ProductRecommendationController.java
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

    @GetMapping
    public List<ProductRecommendation> getAllRecommendations() {
        return productRecommendationService.getAllRecommendations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRecommendation> getRecommendationById(@PathVariable Long id) {
        Optional<ProductRecommendation> recommendation = productRecommendationService.getRecommendationById(id);
        return recommendation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductRecommendation createRecommendation(@RequestBody ProductRecommendation recommendation) {
        return productRecommendationService.createRecommendation(recommendation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRecommendation> updateRecommendation(@PathVariable Long id, @RequestBody ProductRecommendation recommendationDetails) {
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecommendation(@PathVariable Long id) {
        productRecommendationService.deleteRecommendation(id);
        return ResponseEntity.noContent().build();
    }
}
