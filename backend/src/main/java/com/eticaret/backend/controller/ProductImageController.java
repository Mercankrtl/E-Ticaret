// src/main/java/com/eticaret/backend/controller/ProductImageController.java
package com.eticaret.backend.controller;

import com.eticaret.backend.model.ProductImage;
import com.eticaret.backend.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-images")
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @GetMapping
    public List<ProductImage> getAllImages() { return productImageService.getAllImages(); }

    @GetMapping("/{id}")
    public ResponseEntity<ProductImage> getImageById(@PathVariable Long id) {
        Optional<ProductImage> productImage = productImageService.getImageById(id);
        return productImage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductImage createImage(@RequestBody ProductImage productImage) {
        return productImageService.createImage(productImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductImage> updateImage(@PathVariable Long id, @RequestBody ProductImage imageDetails) {
        Optional<ProductImage> existingImage = productImageService.getImageById(id);
        if (existingImage.isPresent()) {
            ProductImage image = existingImage.get();
            image.setImageUrl(imageDetails.getImageUrl());
            image.setIsPrimary(imageDetails.getIsPrimary());
            image.setProduct(imageDetails.getProduct());
            ProductImage updatedImage = productImageService.updateImage(image);
            return ResponseEntity.ok(updatedImage);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        productImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
