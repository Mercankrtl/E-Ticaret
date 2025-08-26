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

    // Tüm ürün görsellerini getir
    @GetMapping
    public List<ProductImage> getAllImages() {
        return productImageService.getAllImages();
    }

    // ID ile ürün görseli getir
    @GetMapping("/{id}")
    public ResponseEntity<ProductImage> getImageById(@PathVariable Integer id) {
        Optional<ProductImage> productImage = productImageService.getImageById(id);
        return productImage.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni ürün görseli oluştur
    @PostMapping
    public ProductImage createImage(@RequestBody ProductImage productImage) {
        return productImageService.createImage(productImage);
    }

    // Ürün görseli güncelle
    @PutMapping("/{id}")
    public ResponseEntity<ProductImage> updateImage(@PathVariable Integer id, @RequestBody ProductImage imageDetails) {
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

    // Ürün görseli sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Integer id) {
        productImageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
