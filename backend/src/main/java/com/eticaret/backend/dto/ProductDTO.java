package com.eticaret.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity -> DTO dönüşümünde:
 *  - BigDecimal (entity) -> double (DTO)
 *  - Date (entity) -> String ISO-8601 (DTO)
 *  - Görsel için hem image hem imageUrl dolu olsun (frontend uyumluluğu)
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private Long id;
    private String name;
    private String description;

    private double price;     // BigDecimal -> double
    private double discount;  // BigDecimal -> double

    private int stock;

    private boolean bestSeller;
    private boolean newProduct;
    private boolean dailyDeal;

    private String createdAt; // Date -> ISO-8601 string

    // Görsel alanları (ikisini de dolduracağız)
    private String image;     // entity'deki image path
    private String imageUrl;  // primary image url (yoksa image ile aynı)

    // Sezon bilgisi (nullable olabilir)
    private Long seasonId;
    private String seasonName;
}
