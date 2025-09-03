package com.eticaret.backend.controller;

import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.ProductImage;
import com.eticaret.backend.service.ProductService;
import com.eticaret.backend.service.ProductImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/daily-deals")
@RequiredArgsConstructor
public class DailyDealsController {

    private final ProductService productService;
    private final ProductImageService productImageService;

    @GetMapping
    public List<Map<String, Object>> getDailyDeals() {
        List<Product> dailyDeals = productService.getDailyDeals();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Product p : dailyDeals) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", p.getId());
            map.put("name", p.getName());
            map.put("description", p.getDescription());
            map.put("price", p.getPrice());
            map.put("discount", p.getDiscount());
            map.put("stock", p.getStock());
            map.put("bestSeller", p.isBestSeller());
            map.put("newProduct", p.isNewProduct());
            map.put("createdAt", p.getCreatedAt());
            map.put("image", p.getImage());


            List<ProductImage> images = productImageService.getImagesByProductId(p.getId());
            images.stream()
                    .filter(ProductImage::getIsPrimary)
                    .findFirst()
                    .ifPresent(pi -> map.put("imageUrl", pi.getImageUrl()));

            result.add(map);
        }
        return result;
    }
}
