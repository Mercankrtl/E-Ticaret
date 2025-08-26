// src/main/java/com/eticaret/backend/service/ProductTagService.java
package com.eticaret.backend.service;

import com.eticaret.backend.model.ProductTag;
import com.eticaret.backend.model.ProductTagId;
import com.eticaret.backend.repository.ProductTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTagService {

    @Autowired
    private ProductTagRepository productTagRepository;

    public List<ProductTag> getAllProductTags() { return productTagRepository.findAll(); }
    public Optional<ProductTag> getProductTagById(ProductTagId id) { return productTagRepository.findById(id); }
    public ProductTag createProductTag(ProductTag productTag) { return productTagRepository.save(productTag); }
    public ProductTag updateProductTag(ProductTag productTag) { return productTagRepository.save(productTag); }
    public void deleteProductTag(ProductTagId id) { productTagRepository.deleteById(id); }
    public List<ProductTag> getTagsByProductId(Long productId) { return productTagRepository.findByProduct_Id(productId); }
}
