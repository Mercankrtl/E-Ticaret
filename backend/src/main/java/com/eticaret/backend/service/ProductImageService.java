package com.eticaret.backend.service;

import com.eticaret.backend.model.ProductImage;
import com.eticaret.backend.repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    // Tüm ürün görsellerini getir
    public List<ProductImage> getAllImages() {
        return productImageRepository.findAll();
    }

    // ID'ye göre görsel getir
    public Optional<ProductImage> getImageById(Integer id) {
        return productImageRepository.findById(id);
    }

    // Yeni ürün görseli ekle
    public ProductImage createImage(ProductImage image) {
        return productImageRepository.save(image);
    }

    // Ürün görselini güncelle
    public ProductImage updateImage(ProductImage image) {
        return productImageRepository.save(image);
    }

    // Ürün görselini sil
    public void deleteImage(Integer id) {
        productImageRepository.deleteById(id);
    }

    // Belirli bir ürüne ait tüm görselleri getir
    public List<ProductImage> getImagesByProductId(Integer productId) {
        return productImageRepository.findByProductId(productId);
    }
}
