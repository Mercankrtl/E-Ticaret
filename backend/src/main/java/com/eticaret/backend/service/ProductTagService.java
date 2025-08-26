package com.eticaret.backend.service;

import com.eticaret.backend.model.ProductTag;
import com.eticaret.backend.repository.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTagService {

    @Autowired
    private ProductTagRepository productTagRepository;

    // Tüm ProductTag kayıtlarını getir
    public List<ProductTag> getAllProductTags() {
        return productTagRepository.findAll();
    }

    // ID ile ProductTag getir
    public Optional<ProductTag> getProductTagById(Integer id) {
        return productTagRepository.findById(id);
    }

    // Yeni ProductTag oluştur
    public ProductTag createProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    // ProductTag güncelle
    public ProductTag updateProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    // ProductTag sil
    public void deleteProductTag(Integer id) {
        productTagRepository.deleteById(id);
    }

    // Ürüne ait tag'ları getir
    public List<ProductTag> getTagsByProductId(Integer productId) {
        return productTagRepository.findByProductId(productId);
    }
}
