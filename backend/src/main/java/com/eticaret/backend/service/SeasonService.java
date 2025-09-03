package com.eticaret.backend.service;

import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.Season;
import com.eticaret.backend.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final SeasonRepository seasonRepository;

    // Tüm mevsimleri getir
    public List<Season> getAllSeasons() {
        return seasonRepository.findAll();
    }

    // İsim ile mevsim bul (Lazy fix)
    public Optional<Season> getSeasonByName(String name) {
        return seasonRepository.findByNameWithProducts(name);
    }

    // Bir mevsime ait ürünleri getir (Lazy fix)
    public List<Product> getProductsBySeason(String name) {
        return seasonRepository.findByNameWithProducts(name)
                .map(Season::getProducts)
                .orElse(List.of()); // eğer mevsim yoksa boş liste
    }

    // ID ile tek bir mevsim getir (Lazy fix)
    public Optional<Season> getSeasonById(Long id) {
        return seasonRepository.findByIdWithProducts(id);
    }
}
