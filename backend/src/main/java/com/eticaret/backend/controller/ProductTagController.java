// src/main/java/com/eticaret/backend/controller/ProductTagController.java
package com.eticaret.backend.controller;

import com.eticaret.backend.model.ProductTag;
import com.eticaret.backend.model.ProductTagId;
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

    @GetMapping
    public List<ProductTag> getAllProductTags() { return productTagService.getAllProductTags(); }

    // Bileşik anahtar: path param olarak almak için iki parametre
    @GetMapping("/product/{productId}/tag/{tagId}")
    public ResponseEntity<ProductTag> getProductTagById(@PathVariable Long productId, @PathVariable Long tagId) {
        ProductTagId id = new ProductTagId(productId, tagId);
        Optional<ProductTag> productTag = productTagService.getProductTagById(id);
        return productTag.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductTag createProductTag(@RequestBody ProductTag productTag) {
        return productTagService.createProductTag(productTag);
    }

    @PutMapping("/product/{productId}/tag/{tagId}")
    public ResponseEntity<ProductTag> updateProductTag(@PathVariable Long productId, @PathVariable Long tagId,
                                                       @RequestBody ProductTag productTagDetails) {
        ProductTagId id = new ProductTagId(productId, tagId);
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

    @DeleteMapping("/product/{productId}/tag/{tagId}")
    public ResponseEntity<Void> deleteProductTag(@PathVariable Long productId, @PathVariable Long tagId) {
        productTagService.deleteProductTag(new ProductTagId(productId, tagId));
        return ResponseEntity.noContent().build();
    }
}
