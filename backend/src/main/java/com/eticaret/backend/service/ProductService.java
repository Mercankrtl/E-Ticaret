package com.eticaret.backend.service;

import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.Season;
import com.eticaret.backend.repository.ProductRepository;
import com.eticaret.backend.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SeasonRepository seasonRepository;

    // Tüm ürünleri çek
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Ürünü kaydet
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Günlük indirim ürünlerini çek
    public List<Product> getDailyDeals() {
        return productRepository.findByDailyDealTrue();
    }

    // Sezonlara göre ürünleri gruplandır
    public Map<String, List<Product>> getSeasonalProducts() {
        Map<String, List<Product>> seasonalMap = new HashMap<>();

        // Tüm mevsimleri al
        List<Season> seasons = seasonRepository.findAll();

        // Her bir mevsime bağlı ürünleri map’e koy
        for (Season season : seasons) {
            seasonalMap.put(
                    season.getName().toLowerCase(), // key: spring, summer...
                    new ArrayList<>(season.getProducts()) // value: o mevsime ait ürünler
            );
        }

        return seasonalMap;
    }
}
