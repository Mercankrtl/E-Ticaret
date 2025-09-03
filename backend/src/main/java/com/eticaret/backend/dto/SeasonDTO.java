package com.eticaret.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Season için DTO sınıfı
 * JSON recursion (Season -> Product -> Season ...) sorununu engellemek için
 * sadece gerekli alanları frontend'e taşır.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeasonDTO {

    private Long id;           // mevsim ID
    private String name;       // mevsim adı (spring, summer, autumn, winter)
    private int productCount;  // bu sezona ait ürün sayısı

    // Eğer ilerde frontend'e sezon resmi koyacaksan:
    // private String imageUrl;
}
