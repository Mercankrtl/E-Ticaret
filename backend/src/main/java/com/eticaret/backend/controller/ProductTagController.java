package com.eticaret.backend.controller;

import com.eticaret.backend.model.ProductTag;
import com.eticaret.backend.service.ProductTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/product-tags")
public class ProductTagController {

    @Autowired
    private ProductTagService productTagService;

    // Tüm product-tag ilişkilerini getir
    @GetMapping
    public List<ProductTag> getAllProductTags() {
        return productTagService.getAllProductTags();
    }

    // ID ile product-tag getir
    @GetMapping("/{id}")
    public ResponseEntity<ProductTag> getProductTagById(@PathVariable Integer id) {
        Optional<ProductTag> productTag = productTagService.getProductTagById(id);
        return productTag.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Yeni product-tag oluştur
    @PostMapping
    public ProductTag createProductTag(@RequestBody ProductTag productTag) {
        return productTagService.createProductTag(productTag);
    }

    // Product-tag güncelle
    @PutMapping("/{id}")
    public ResponseEntity<ProductTag> updateProductTag(@PathVariable Integer id, @RequestBody ProductTag productTagDetails) {
        Optional<ProductTag> existingProductTag = productTagService.getProductTagById(id);
        if (existingProductTag.isPresent()) {
            ProductTag productTag = existingProductTag.get();
            productTag.setProduct(productTagDetails.getProduct());
            productTag.setTag(productTagDetails.getTag());
            ProductTag updatedProductTag = productTagService.updateProductTag(productTag);
            return ResponseEntity.ok(updatedProductTag);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Product-tag sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductTag(@PathVariable Integer id) {
        productTagService.deleteProductTag(id);
        return ResponseEntity.noContent().build();
    }
}
