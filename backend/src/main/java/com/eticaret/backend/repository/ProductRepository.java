package com.eticaret.backend.repository;

import com.eticaret.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByDailyDealTrue(); // dailyDeal = true olan ürünleri getir

    // Hem ManyToOne (p.category) hem de ManyToMany (p.categories) if7erinden kategori adına gf6re crcnleri getir
    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN p.categories c " +
            "LEFT JOIN p.category pc " +
            "WHERE LOWER(c.name) = LOWER(:categoryName) OR LOWER(pc.name) = LOWER(:categoryName)")
    List<Product> findByCategoryNameIgnoreCase(@Param("categoryName") String categoryName);
}
