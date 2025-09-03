package com.eticaret.backend.controller;

import com.eticaret.backend.dto.ProductDTO;
import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.ProductImage;
import com.eticaret.backend.service.ProductImageService;
import com.eticaret.backend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;
    private final ProductImageService productImageService;

    // ---- Helper'lar (yukarıda verdiğim ikisini buraya kopyala) ----
    private static String toIso(java.util.Date date) {
        if (date == null) return null;
        return date.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .format(java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    private ProductDTO toDto(Product p, String primaryImageUrl) {
        double price = (p.getPrice() != null) ? p.getPrice().doubleValue() : 0.0;
        double discount = (p.getDiscount() != null) ? p.getDiscount().doubleValue() : 0.0;
        String createdAt = toIso(p.getCreatedAt());

        Long seasonId = (p.getSeason() != null) ? p.getSeason().getId() : null;
        String seasonName = (p.getSeason() != null) ? p.getSeason().getName() : null;

        String imageUrl = (primaryImageUrl != null && !primaryImageUrl.isBlank())
                ? primaryImageUrl
                : p.getImage();

        return ProductDTO.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .price(price)
                .discount(discount)
                .stock(p.getStock())
                .bestSeller(p.isBestSeller())
                .newProduct(p.isNewProduct())
                .dailyDeal(p.isDailyDeal())
                .createdAt(createdAt)
                .image(p.getImage())
                .imageUrl(imageUrl)
                .seasonId(seasonId)
                .seasonName(seasonName)
                .build();
    }
    // ---------------------------------------------------------------

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return products.stream().map(p -> {
            // primary image (null-safe)
            String primaryImageUrl = Optional.ofNullable(productImageService.getImagesByProductId(p.getId()))
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(pi -> Boolean.TRUE.equals(pi.getIsPrimary()))
                    .map(ProductImage::getImageUrl)
                    .findFirst()
                    .orElse(null);

            return toDto(p, primaryImageUrl);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
}
