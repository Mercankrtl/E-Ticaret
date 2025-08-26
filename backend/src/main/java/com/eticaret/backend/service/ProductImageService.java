// src/main/java/com/eticaret/backend/service/ProductImageService.java
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

    public List<ProductImage> getAllImages() { return productImageRepository.findAll(); }
    public Optional<ProductImage> getImageById(Long id) { return productImageRepository.findById(id); }
    public ProductImage createImage(ProductImage image) { return productImageRepository.save(image); }
    public ProductImage updateImage(ProductImage image) { return productImageRepository.save(image); }
    public void deleteImage(Long id) { productImageRepository.deleteById(id); }
    public List<ProductImage> getImagesByProductId(Long productId) { return productImageRepository.findByProduct_Id(productId); }
}
