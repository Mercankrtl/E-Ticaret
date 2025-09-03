package com.eticaret.backend.controller;

import com.eticaret.backend.dto.ProductDTO;
import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.Season;
import com.eticaret.backend.model.ProductImage;
import com.eticaret.backend.service.ProductImageService;
import com.eticaret.backend.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/seasons")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SeasonController {

    private final SeasonService seasonService;
    private final ProductImageService productImageService;

    // Tüm mevsimleri getir
    @GetMapping
    public List<Season> getAllSeasons() {
        return seasonService.getAllSeasons();
    }

    // Sezon bazlı ürünleri DTO ile getir
    @GetMapping("/{seasonName}/products")
    public List<ProductDTO> getProductsBySeason(@PathVariable String seasonName) {
        List<Product> products = seasonService.getProductsBySeason(seasonName);

        return products.stream().map(p -> {
            Optional<ProductImage> primaryImage = Optional.ofNullable(
                            productImageService.getImagesByProductId(p.getId()))
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(pi -> Boolean.TRUE.equals(pi.getIsPrimary()))
                    .findFirst();

            String imageUrl = primaryImage.map(ProductImage::getImageUrl).orElse(p.getImage());
            Long seasonId = p.getSeason() != null ? p.getSeason().getId() : null;
            String seasonNameVal = p.getSeason() != null ? p.getSeason().getName() : null;

            return new ProductDTO(
                    p.getId(),
                    p.getName(),
                    p.getDescription(),
                    p.getPrice().doubleValue(),
                    p.getStock(),
                    p.isBestSeller(),
                    p.isNewProduct(),
                    p.getCreatedAt() != null ? p.getCreatedAt().toString() : null,
                    imageUrl,
                    seasonId,
                    seasonNameVal
            );
        }).collect(Collectors.toList());
    }

    // Belirli ID’ye göre tek bir mevsimi çek
    @GetMapping("/{id}")
    public Season getSeasonById(@PathVariable Long id) {
        return seasonService.getSeasonById(id).orElse(null);
    }
}
