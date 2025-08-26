// src/main/java/com/eticaret/backend/repository/ProductImageRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    // product alanı bir ilişki olduğu için "_"
    List<ProductImage> findByProduct_Id(Long productId);
}
